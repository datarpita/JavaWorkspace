package com.tsc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long activityId;
	
	@Column
	private String activityName;
	
	@ManyToMany (mappedBy="activities")	
	List<Student> students;
	
	public Activity() {
		
	}

	public Activity(String activityName) {
		super();	
		this.activityName = activityName;
	}

	
	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
