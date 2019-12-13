package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dto.Answer;
import com.dto.Exam;
import com.dto.Login;
import com.dto.Score;
import com.dto.Student;

public class ExamDAO
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
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

	public boolean saveExam(Exam ref)
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
	
	public List<Exam> showExamsForTeachers(String username)
	{
		List<Exam> lst = null;
		
		Login log = new Login();
		log.setUsername(username);
		
		try 
		{
			lst = htemplate.execute(new HibernateCallback<List<Exam>>() {
				
				@SuppressWarnings("unchecked")
				@Override
				public List<Exam> doInHibernate(Session session) throws HibernateException {
					
					Query q = session.createQuery("FROM Exam E where E.login=:log");
					
					q.setParameter("log", log);
					
					List<Exam> lst = q.list();
					
					if(lst.size()>0)
						return lst;
					else
						return null;
				}
			});
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return lst;
	}
	
	public List<Exam> getAllNotTakenExamsForStudents(String username)
	{
				
		List<Exam> lst = null;
		
		Login log = new Login();
		log.setUsername(username);
		
		try 
		{
			lst = htemplate.execute(new HibernateCallback<List<Exam>>() {
				
				@SuppressWarnings({ "unchecked" })
				@Override
				public List<Exam> doInHibernate(Session session) throws HibernateException {
					
					Query query = session.createQuery("FROM Student S where S.login=:log");
					query.setParameter("log", log);
					
					List<Student> st = query.list();
					int a = st.get(0).getCourse();
					String b = st.get(0).getSemester();
					
					Query q = session.createQuery("FROM Exam E where E.course=:a AND E.semester=:b");
					q.setParameter("a", a);
					q.setParameter("b", b);
					
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
	
	public List<Score> getAllTakenExamsForStudents(String username)
	{
		List<Score> lst = null;
		
		try 
		{
			lst = htemplate.execute(new HibernateCallback<List<Score>>() {
				
				@SuppressWarnings({ "unchecked" })
				@Override
				public List<Score> doInHibernate(Session session) throws HibernateException {
					
					Query query = session.createQuery("FROM Score S where S.username=:username");
					query.setParameter("username", username);
					
					List<Score> st = query.list();
					
					if(st.size()>0)
						return st;
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
	
	public List<Score> showAllExams()
	{
		List<Score> lst = null;
		
		try
		{
			lst = htemplate.execute(new HibernateCallback<List<Score>>() {
				
				@SuppressWarnings({ "unchecked" })
				@Override
				public List<Score> doInHibernate(Session session) throws HibernateException {
					
					Query query = session.createQuery("FROM Score S");
//					query.setParameter("username", username);
					
					List<Score> st = query.list();
					
					if(st.size()>0)
						return st;
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
