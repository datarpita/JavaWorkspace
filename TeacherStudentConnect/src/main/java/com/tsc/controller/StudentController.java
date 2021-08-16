package com.tsc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.entity.Activity;
import com.tsc.entity.Bike;
import com.tsc.entity.User;
import com.tsc.model.AddStudentModel;
import com.tsc.model.StudentModel;
import com.tsc.paging.Page;
import com.tsc.paging.PagingRequest;
import com.tsc.service.StudentService;

/** This class is used to perform the majority functions related to students 
 * 
 * @author Arpita Datta
 *
 */
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;	
	
	
	/** To fetch the student data from database and 
	 * process it to populate the Page object to be displayed in the datatable
	 * @param pagingRequest
	 * @return : Page Object with all the student details and page related data
	 */
	@PostMapping("/students")
    public Page<StudentModel> list(@RequestBody PagingRequest pagingRequest) {
		
		Page<StudentModel> obj = studentService.getStudents(pagingRequest);
		System.out.println("List of students-->" + obj.getData());
        return obj;
    }	
	
	/** To fetch Bike and Activities from database 
	 * and redirect to the Add Student page	 * 
	 * @param model
	 * @param req
	 * @return : ModelAndView object linked to the Add Student page
	 */
	@GetMapping(path="/addstudent")
	public ModelAndView addStudent(Model model, HttpServletRequest req) {
		User sessionUser = (User)req.getSession().getAttribute("user");		
		model.addAttribute("user", sessionUser);
		
		
		model.addAttribute("addstudentmodel", new AddStudentModel());
		List<Activity> allActivities = studentService.getAllActivities();		
		model.addAttribute("predefinedactivitylist", allActivities);
		List<Bike> allBikes = studentService.getAllBikes();
		model.addAttribute("predefinedbikelist", allBikes);
		return new ModelAndView("addstudent");
	}
	
	/** To save the student details in the database
	 * 
	 * @param addstudentmodel
	 * @param req
	 * @param model
	 * @return : The Home page with refreshed list of students
	 */
	@PostMapping(path="/savestudent")
	public ModelAndView saveStudent(AddStudentModel addstudentmodel, HttpServletRequest req, Model model) {
		User sessionUser = (User)req.getSession().getAttribute("user");		
		model.addAttribute("user", sessionUser);
		
		System.out.println("New student--->"+addstudentmodel);
		
		List<String> errorList = validate(addstudentmodel);
		if (errorList.size()>0) {
			model.addAttribute("errorlist", errorList);
			model.addAttribute("addstudentmodel",addstudentmodel);
			List<Activity> allActivities = studentService.getAllActivities();		
			model.addAttribute("predefinedactivitylist", allActivities);
			List<Bike> allBikes = studentService.getAllBikes();
			model.addAttribute("predefinedbikelist", allBikes);
			return new ModelAndView("addstudent");
		}
		studentService.saveStudent(addstudentmodel);
		
		
		return new ModelAndView("home");
		
	}
	
	/** To validate the field values for Student
	 * 
	 * @param studObj
	 * @return : A list of error messages (if any)
	 */
	private List<String> validate(AddStudentModel studObj){
		
		List<String> errorList = new ArrayList<>();		
		if (!(studObj.getGender().equalsIgnoreCase("male") || studObj.getGender().equalsIgnoreCase("female"))) {
			errorList.add("Gender value should be either male or female");
		}
		
		try {
			Integer grade = Integer.parseInt(studObj.getGrade());
			System.out.println("grade value-->"+grade);
		} catch(NumberFormatException e) {
			errorList.add("Grade value should be in integer");
		}
		
		try {
			Integer notebook = Integer.parseInt(studObj.getNotebooks());
			System.out.println("notebook value-->"+notebook);
		} catch(NumberFormatException e) {
			errorList.add("Notebook value should be in integer");
		}
		
		try {
			Double gpa = Double.parseDouble(studObj.getGpa());
			System.out.println("GPA value-->"+gpa);
		} catch(NumberFormatException e) {
			errorList.add("GPA value should be in decimal format");
		}
		
		
		LocalDate admDate = studObj.getAdmissiondate();
		if (admDate.isAfter(LocalDate.now())){
			errorList.add("Admission value cannot be a future date");
		}		
		
		return errorList;
	}
	
	/* Unused method
	@PostMapping("/students/array")
    public PageArray array(@RequestBody PagingRequest pagingRequest) {
        return studentService.getStudentsArray(pagingRequest);
    }
    */

}
