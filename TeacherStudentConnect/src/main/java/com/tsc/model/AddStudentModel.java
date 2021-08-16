package com.tsc.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class AddStudentModel {
	
	private String name;
	
	
    private String grade;
	
    private String gpa;
	
    private String gender;
	
    private String notebooks;
    
    private List<Long> activityIds;
    
    private Long bikeId;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy")    
    private LocalDate admissiondate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(String notebooks) {
		this.notebooks = notebooks;
	}

	public List<Long> getActivityIds() {
		return activityIds;
	}

	public void setActivityIds(List<Long> activityIds) {
		this.activityIds = activityIds;
	}

	public Long getBikeId() {
		return bikeId;
	}

	public void setBikeId(Long bikeId) {
		this.bikeId = bikeId;
	}

	public LocalDate getAdmissiondate() {
		return admissiondate;
	}

	public void setAdmissiondate(LocalDate admissiondate) {
		this.admissiondate = admissiondate;
	}

	@Override
	public String toString() {
		return "AddStudentModel [name=" + name + ", grade=" + grade + ", gpa=" + gpa + ", gender=" + gender
				+ ", notebooks=" + notebooks + ", activityIds=" + activityIds + ", bikeId=" + bikeId
				+ ", admissiondate=" + admissiondate + "]";
	}

}
