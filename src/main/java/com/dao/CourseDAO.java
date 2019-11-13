package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dto.Course;

public class CourseDAO 
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public CourseDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HibernateTemplate getHtemplate() {
		return htemplate;
	}

	public void setHtemplate(HibernateTemplate htemplate) {
		this.htemplate = htemplate;
	}

	public SessionFactory getSfact() {
		return sfact;
	}

	public void setSfact(SessionFactory sfact) {
		this.sfact = sfact;
	}

//	public List<Course> getAllCourses()
//	{
//		List<Course> lst = new ArrayList<Course>();
//		
//		try 
//		{
//			courseRepository.findAll().forEach(lst::add);;
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return lst;
//	}
}