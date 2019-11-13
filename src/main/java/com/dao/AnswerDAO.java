package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dto.Answer;

public class AnswerDAO 
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public AnswerDAO() {
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

	public boolean saveAnswer(Answer ref)
	{
		boolean b = false;
		Session s = sfact.openSession();
		Transaction tr = s.beginTransaction();
		
		try
		{
			s.save(ref);
			
			tr.commit();
			s.close();
			
			b = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		return b;
	}
	
	public List<Answer> getAllAnswersByStudent(String rollno)
	{
		List<Answer> lst = null;
		
		try 
		{
//			lst = repository.findAllAnswersByStudents(rollno);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return lst;
	}
	
	public List<Object[]> getAllQuestionsAndAnswersByStudents()
	{
		List<Object[]> lst = null;
		
		try
		{
//			lst = repository.findAllAnswers();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return lst;
	}
}