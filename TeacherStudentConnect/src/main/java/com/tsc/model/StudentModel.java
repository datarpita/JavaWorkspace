package com.tsc.model;



import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class StudentModel {
	
	
	private String name;
	@JsonProperty("grade_level")
    private int gradeLevel;
	
    private double gpa;
	
    private String gender;
	
    private int notebooks;
    
    private String activities;
    
    private String bikedetails;  

	@JsonFormat(pattern = "yyyy/MM/dd")    
    private LocalDate admissiondate;
	
	public StudentModel() {
		
	}	
	
	public StudentModel(String name, int gradeLevel, double gpa, String gender, int notebooks, String activities,
				String bikedetails, LocalDate admissiondate) {
			super();
			this.name = name;
			this.gradeLevel = gradeLevel;
			this.gpa = gpa;
			this.gender = gender;
			this.notebooks = notebooks;
			this.activities = activities;
			this.bikedetails = bikedetails;
			this.admissiondate = admissiondate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(int notebooks) {
		this.notebooks = notebooks;
	}
	

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getBikedetails() {
		return bikedetails;
	}

	public void setBikedetails(String bikedetails) {
		this.bikedetails = bikedetails;
	}
	

	/*public Date getAdmissiondate() {
		return admissiondate;
	}

	public void setAdmissiondate(Date admissiondate) {
		this.admissiondate = admissiondate;
	}*/

	@Override
	public String toString() {
		return "StudentModel [name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa + ", gender=" + gender
				+ ", notebooks=" + notebooks + ", activities=" + activities + ", bikedetails=" + bikedetails
				+ ", admissiondate=" + admissiondate + "]";
	}

	public LocalDate getAdmissiondate() {
		return admissiondate;
	}

	public void setAdmissiondate(LocalDate admissiondate) {
		this.admissiondate = admissiondate;
	}
    
    

}
