package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courseid")
	private int courseid;
	
	@Column(name = "coursename")
	private String coursename;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}