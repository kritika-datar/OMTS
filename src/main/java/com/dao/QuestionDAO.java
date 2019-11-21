package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dto.Exam;
import com.dto.Question;

public class QuestionDAO 
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public QuestionDAO() {
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
	
//	public boolean saveQuestion(Question ref)
//	{
//		boolean b = false;
//		
//		try
//		{
//			repository.save(ref);
//			b = true;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//		return b;
//	}
//	
//	public boolean deleteQuestion(Question ref)
//	{
//		boolean b = false;
//		
//		try 
//		{
//			Optional<Question> opt = repository.findById(ref.getQuestionid());
//			
//			if(opt.isPresent())
//			{
//				repository.delete(ref);
//				b = true;
//			}
//			
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return b;
//	}
//	
//	public boolean updateQuestion(Question ref)
//	{
//		boolean b = false;
//		
//		try
//		{
//			Optional<Question> opt = repository.findById(ref.getQuestionid());
//			
//			if(opt.isPresent())
//			{
//				repository.save(ref);
//				b = true;
//			}
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return b;
//	}
//	
	public List<Question> getAllQuestionsByExamId(int examid)
	{
		List<Question> lst = null;
		
		Exam exam = new Exam();
		exam.setExamid(examid);
		
		try 
		{
			lst = htemplate.execute(new HibernateCallback<List<Question>>() {
				
				@SuppressWarnings("unchecked")
				@Override
				public List<Question> doInHibernate(Session session) throws HibernateException {
					
					Query q = session.createQuery("FROM Question Q where Q.exam=:exam");
					
					q.setParameter("exam", exam);
					
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
