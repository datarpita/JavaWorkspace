package com.tsc.service;

import static org.mockito.Mockito.doReturn;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tsc.dao.StudentDao;
import com.tsc.entity.Activity;
import com.tsc.entity.Bike;
import com.tsc.entity.Student;
import com.tsc.model.StudentModel;
import com.tsc.paging.Column;
import com.tsc.paging.Direction;
import com.tsc.paging.Order;
import com.tsc.paging.Page;
import com.tsc.paging.PagingRequest;
import com.tsc.paging.Search;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentDao studentDao;
	
	@Test
	@DisplayName("Test method to get all students")
	void testGetStudents() {
		
		Bike b1 = new Bike("Classic 350","Royal Enfield");
		Bike b2 = new Bike("YZF R15", "Yamaha");
		Activity a1 = new Activity("swimming");
		Activity a2 = new Activity("dancing");
		List<Activity> activities = Arrays.asList(a1,a2);		
		Date admDate = Date.valueOf(LocalDate.of(2019, 2, 4));
		
		Student s1 = new Student("Adam",2, 3.6,"male",23,b1, activities, admDate);
		Student s2 = new Student("Zenny",3, 2.8,"female",6,b2, activities, admDate);
		Student s3 = new Student("Gione",4, 4.0,"male",11,b1, activities, admDate);
		
		List<Student> studentList = Arrays.asList(s1,s2,s3);        
		doReturn(studentList).when(studentDao).findAll();
		
		// Test case 1
		PagingRequest pageReq1 = new PagingRequest();
        pageReq1.setStart(0);
        pageReq1.setLength(10);	
		Page<StudentModel> page1 = studentService.getStudents(pageReq1);		
		Assertions.assertTrue(page1 != null, "Data not found");
		Assertions.assertSame(page1.getData().size(), 3, "The list of students is not same");		
	}
	
	
	@Test
	@DisplayName("Test method to search students")
	void testSearchStudents() {
		Bike b1 = new Bike("Classic 350","Royal Enfield");
		Bike b2 = new Bike("YZF R15", "Yamaha");
		Activity a1 = new Activity("swimming");
		Activity a2 = new Activity("dancing");
		List<Activity> activities = Arrays.asList(a1,a2);		
		Date admDate = Date.valueOf(LocalDate.of(2019, 2, 4));
		
		Student s1 = new Student("Adam",2, 3.6,"male",23,b1, activities, admDate);
		Student s2 = new Student("Zenny",3, 2.8,"female",6,b2, activities, admDate);
		Student s3 = new Student("Gione",4, 4.0,"male",11,b1, activities, admDate);
		
		List<Student> studentList = Arrays.asList(s1,s2,s3);        
		doReturn(studentList).when(studentDao).findAll();
		
		// Test case 2
		PagingRequest pageReq2 = new PagingRequest();
		Search search = new Search();
		search.setValue("ad");
        pageReq2.setStart(0);
        pageReq2.setLength(10);	
        pageReq2.setSearch(search);        
        Page<StudentModel> page2 = studentService.getStudents(pageReq2);		
		Assertions.assertTrue(page2 != null, "Data not found");
		Assertions.assertSame(page2.getData().size(), 1, "Student Adam is not found");
	}
	
	
	@Test
	@DisplayName("Test method to sort student names")
	void testSortStudentNames() {
		Bike b1 = new Bike("Classic 350","Royal Enfield");
		Bike b2 = new Bike("YZF R15", "Yamaha");
		Activity a1 = new Activity("swimming");
		Activity a2 = new Activity("dancing");
		List<Activity> activities = Arrays.asList(a1,a2);		
		Date admDate = Date.valueOf(LocalDate.of(2019, 2, 4));
		
		Student s1 = new Student("Adam",2, 3.6,"male",23,b1, activities, admDate);
		Student s2 = new Student("Zenny",3, 2.8,"female",6,b2, activities, admDate);
		Student s3 = new Student("Gione",4, 4.0,"male",11,b1, activities, admDate);
		
		List<Student> studentList = Arrays.asList(s1,s2,s3);        
		doReturn(studentList).when(studentDao).findAll();
		
		// Test case 3
		PagingRequest pageReq3 = new PagingRequest();		
        pageReq3.setStart(0);
        pageReq3.setLength(10);
        Column c1 = new Column("name","name", true,true, null);
        Column c2 = new Column("gender","gender", true,true, null);
        Column c3 = new Column("grade_level","grade_level", true,true, null);
        Column c4 = new Column("gpa","gpa", true,true, null);
        Column c5 = new Column("notebooks","notebooks", true,true, null);
        Column c6 = new Column("activities","activities", true,true, null);
        Column c7 = new Column("bikedetails","bikedetails", true,true, null);
        Column c8 = new Column("admissiondate","admissiondate", true,true, null);
        pageReq3.setColumns(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8));
        Order order = new Order(0, Direction.desc);
        pageReq3.setOrder(Arrays.asList(order));     
        Page<StudentModel> page3 = studentService.getStudents(pageReq3);		
		Assertions.assertTrue(page3 != null, "Data not found");
		Optional<String> sortedNames = page3.getData().stream()
					   								  .map(StudentModel::getName)
					   								  .reduce((n1,n2) -> n1.concat(", ").concat(n2));
		Assertions.assertEquals(sortedNames.get(), "Zenny, Gione, Adam", "Sorting of names in descending order is not correct");
	}

}
