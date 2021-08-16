package com.tsc.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentId;
	@Column
    private String name;
	@Column
    private int gradeLevel;
	@Column
    private double gpa;
	@Column
    private String gender;
	@Column
    private int noteBooks;	
	@ManyToMany
	@JoinTable(name="students_activities")
    List<Activity> activities;
	
	@OneToOne(optional=true)
    private Bike bike;
	
	@Column
	private Date admissiondate;

    public Student(){

    }    

    public Student(String name, int gradeLevel, double gpa, String gender, int noteBooks, Bike bike,
			List<Activity> activities, Date admissiondate) {		
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.noteBooks = noteBooks;
		this.bike = bike;
		this.activities = activities;
		this.admissiondate = admissiondate;
	}


	public long getStudentId() {
		return studentId;
	}


	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}


	public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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



    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public int getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(int noteBooks) {
        this.noteBooks = noteBooks;
    }    

    public void printListOfActivities(){

        System.out.println("List of Activities are : " + this.activities);
    }
    
    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

	public Date getAdmissiondate() {
		return admissiondate;
	}

	public void setAdmissiondate(Date admissiondate) {
		this.admissiondate = admissiondate;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa
				+ ", gender=" + gender + ", noteBooks=" + noteBooks + ", activities=" + activities + ", bike=" + bike
				+ ", admissiondate=" + admissiondate + "]";
	}

}
