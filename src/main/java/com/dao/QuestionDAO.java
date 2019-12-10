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
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dto.Exam;
import com.dto.Question;
import org.json.simple.JSONObject;

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
	
	public String getQuestion(String question_no,int examid)
	{
		String query="select * from question where examid=?";
		JSONObject obj=new JSONObject();

		String URL="localhost:3306/";
		String DATABASE_NAME="omts";
		String USERNAME="root";
		String PASSWORD="root";
		
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://"+URL+DATABASE_NAME,USERNAME,PASSWORD);
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,examid);
			ResultSet rs=ps.executeQuery();
//			ResultSet rs1=null;
			
			if(rs.next()){
				rs.absolute(Integer.parseInt(question_no));
				obj.put("question", rs.getString("question"));
				obj.put("id", rs.getString("questionid"));
				
//				query="select * from question where "+DBDetails.QUESTION_ID_COL+"=?";
//				ps=con.prepareStatement(query);
//				ps.setString(1,rs.getString(DBDetails.ID_COL));
//				rs1=ps.executeQuery();
				
//				if(rs.next()){
//					rs1.absolute(1);
					obj.put("a", rs.getString("optiona"));
					
//					rs1.absolute(2);
					obj.put("b", rs.getString("optionb"));
					
//					rs1.absolute(3);
					obj.put("c", rs.getString("optionc"));
					
//					rs1.absolute(4);
					obj.put("d", rs.getString("optiond"));
				}
//			}
			
			ps.close();
			rs.close();
//			rs1.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj.toString();
		
		
		
		
		
		
//		String a = null;
//		JsonObject obj = new JsonObject();
//		
//		try
//		{
//			a = htemplate.execute(new HibernateCallback<String>() {
//				
//				@Override
//				public String doInHibernate(Session session) throws HibernateException {
//					
//					Query q = session.createQuery("FROM Question Q where Q.questionid=:question_no AND Q.examid=:examid");
//					q.setParameter("question_no", question_no);
//					q.setParameter("examid", examid);
//					
//					List<Object> lst = q.list();
//					Object arr = lst.get(0);
//					
//					return (String)arr;
//				}
//			});
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			return null;
//		}
//		
//		return a;
	}
}
