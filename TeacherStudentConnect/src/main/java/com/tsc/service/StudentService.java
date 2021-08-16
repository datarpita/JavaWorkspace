package com.tsc.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.dao.ActivityDao;
import com.tsc.dao.BikeDao;
import com.tsc.dao.StudentDao;
import com.tsc.entity.Activity;
import com.tsc.entity.Bike;
import com.tsc.entity.Student;
import com.tsc.model.AddStudentModel;
import com.tsc.model.StudentModel;
import com.tsc.paging.Column;
import com.tsc.paging.Order;
import com.tsc.paging.Page;
import com.tsc.paging.PagingRequest;
import com.tsc.utility.StudentComparatorsHelper;

/** This class is used to perform the majority functions related to students 
 * 
 * @author Arpita Datta
 *
 */
@Service
public class StudentService {
	
	private static final Comparator<StudentModel> EMPTY_COMPARATOR = (s1, s2) -> 0;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private BikeDao bikeDao;
	
	/** To fetch the student details and process each object 
	 * to populate the Page object that is required for the datatable in UI
	 * @param pagingRequest
	 * @return : Page object containing student data and page related information 
	 */
	public Page<StudentModel> getStudents(PagingRequest pagingRequest) {
       
        try {
        	
        	//List<StudentModel> studentModelList = new ArrayList<>();
            List<Student> students = studentDao.findAll();  
            
            List<StudentModel> studentModelList = students.stream().map(s -> {
            	StudentModel smodel = new StudentModel();
            	smodel.setName(s.getName());
            	smodel.setGender(s.getGender());
            	smodel.setGradeLevel(s.getGradeLevel());
            	smodel.setGpa(s.getGpa());
            	smodel.setNotebooks(s.getNoteBooks());
            	if (s.getBike() != null) {
            		smodel.setBikedetails(s.getBike().getName() + " " + s.getBike().getModel());
            	}else {
            		smodel.setBikedetails("NA");
            	}
            	if (getStudentActivities(s.getActivities()).isPresent()) {
            		smodel.setActivities(getStudentActivities(s.getActivities()).get());
            	}else {
            		smodel.setActivities("");      
            	}
            	smodel.setAdmissiondate(s.getAdmissiondate().toLocalDate());            	
            	return smodel;
            }).collect(Collectors.toList());
            

            return getPage(studentModelList, pagingRequest);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Page<StudentModel>();
    }
	
	/** Performs different functions - sort, filter, pagination on the 
	 * Student collection 
	 * @param students
	 * @param pagingRequest
	 * @return : Page object containing student data and page related information
	 */
	private Page<StudentModel> getPage(List<StudentModel> students, PagingRequest pagingRequest) {
        List<StudentModel> filtered = students.stream()
                                              .sorted(sortStudents(pagingRequest))
                                              .filter(filterStudents(pagingRequest))
                                              .skip(pagingRequest.getStart())
                                              .limit(pagingRequest.getLength())
                                              .collect(Collectors.toList());

        long count = students.stream()
                             .filter(filterStudents(pagingRequest))
                             .count();

        Page<StudentModel> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }
	
	/** Predicate Functional Interface to perform search on the different fields of 
	 * Student collection based on the search value
	 * @param pagingRequest
	 * @return : Filtered list of student collection
	 */
	private Predicate<StudentModel> filterStudents(PagingRequest pagingRequest) {
        if (pagingRequest.getSearch() == null || pagingRequest.getSearch().getValue().isEmpty()) {
            return student -> true;
        }

        String value = pagingRequest.getSearch().getValue();           
       
        return student -> student.getName().toLowerCase().contains(value)
                || student.getGender().toLowerCase().contains(value)
                || String.valueOf(student.getGradeLevel()).contains(value)
                || String.valueOf(student.getGpa()).contains(value)
                || String.valueOf(student.getBikedetails()).toLowerCase().contains(value)
                || String.valueOf(student.getNotebooks()).contains(value);
    }
	
	/** Perform sort on the student collection on the requested column
	 * 
	 * @param pagingRequest
	 * @return : Sorted collection of student data
	 */
	private Comparator<StudentModel> sortStudents(PagingRequest pagingRequest) {
        if (pagingRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = pagingRequest.getOrder().get(0);

            int columnIndex = order.getColumn();
            Column column = pagingRequest.getColumns().get(columnIndex);

            Comparator<StudentModel> comparator = StudentComparatorsHelper.getComparator(column.getData(), order.getDir());
            if (comparator == null) {
                return EMPTY_COMPARATOR;
            }

            return comparator;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return EMPTY_COMPARATOR;
    }
	
	/** Fetch all the available list of activities
	 * from Activity table
	 * @return : a list of all Activity objects
	 */
    public List<Activity> getAllActivities(){
    	return activityDao.findAll();
    }

	/** fetch all the available Bike data 
	 * from Bike table
	 * @return : a list of Bike objects
	 */
    public List<Bike> getAllBikes(){
    	return bikeDao.findAll();
    }
    
    /** Create a Student entity object from the model object
     * and save it in the Student table
     * @param newStudent
     */
    public void saveStudent(AddStudentModel newStudent) {
    	
    	Student aStudent = new Student();
    	aStudent.setName(newStudent.getName());
    	aStudent.setGender(newStudent.getGender());
    	aStudent.setGradeLevel(Integer.parseInt(newStudent.getGrade()));
    	aStudent.setGpa(Double.parseDouble(newStudent.getGpa()));
    	aStudent.setNoteBooks(Integer.parseInt(newStudent.getNotebooks()));
    	
    	  	
    	List<Activity> activityList = new ArrayList<>();
    	newStudent.getActivityIds().forEach(id ->{
    		Optional<Activity> activityObj = activityDao.findById(id);
    		if (activityObj.isPresent())
    			activityList.add(activityObj.get());    		
    	});
    	
    	aStudent.setActivities(activityList);
    	
    	Optional<Bike> bikeObj = bikeDao.findById(newStudent.getBikeId());
    	if (bikeObj.isPresent())
    		aStudent.setBike(bikeObj.get());
    	aStudent.setAdmissiondate(Date.valueOf(newStudent.getAdmissiondate()));
    	studentDao.save(aStudent);    	
    }	
	
    /** Create a string of activities of a student delimited by comma
     * 
     * @param activities
     * @return
     */
	private Optional<String> getStudentActivities(List<Activity> activities) {
		return activities.stream()
				  .map(Activity::getActivityName)
				  .reduce((a1, a2) -> a1.concat(", ").concat(a2));
	}    
}
