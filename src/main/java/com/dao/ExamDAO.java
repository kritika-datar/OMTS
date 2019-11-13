package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dto.Exam;
import com.dto.Login;

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
	
	public List<Object[]> showExamsForTeachers(String username)
	{
		List<Object[]> lst = null;
		
		Login log = new Login();
		log.setUsername(username);
		
		try 
		{
			lst = htemplate.execute(new HibernateCallback<List<Object[]>>() {
				
				@Override
				public List<Object[]> doInHibernate(Session session) throws HibernateException {
					
					Query q = session.createQuery("FROM Exam E Right Outer Join E.login L where L.log=:log");
					
					q.setParameter("log", log);
					
					List<Object[]> lst = q.list();
					
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
	
//	public List<Exam> showExamsForStudent(Student ref)
//	{
//		List<Exam> lst = null;
//		
//		try 
//		{
//			examRepository.findById(ref.getStudentid());
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return lst;
//	}
//	
//	public List<Exam> showAllExams()
//	{
//		List<Exam> lst = null;
//		
//		try 
//		{
//			examRepository.findAll().forEach(lst::add);
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			return null;
//		}
//		
//		return lst;
//	}
}
