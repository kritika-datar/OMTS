package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
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

	public List<Course> getAllCourses()
	{
		List<Course> lst = null;
		
		try 
		{
			lst = htemplate.execute(new HibernateCallback<List<Course>>() {
				
				@SuppressWarnings("unchecked")
				@Override
				public List<Course> doInHibernate(Session session) throws HibernateException {
					
					Query q = session.createQuery("FROM Course");
					
					if(q.list().size()>0)
						return q.list();
					else
						return null;
				}
			});
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return lst;
	}
}