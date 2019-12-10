package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public static void saveAnswers(int examid, String id, LinkedHashMap lhm)
	{
		String query="insert into answer(recordedanswer, studentid, questionid, examid) values(?,?,?,?)";
		
		String URL="localhost:3306/";
		String DATABASE_NAME="omts";
		String USERNAME="root";
		String PASSWORD="root";
		
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://"+URL+DATABASE_NAME,USERNAME,PASSWORD);

			PreparedStatement ps;
			Set set=lhm.entrySet();
			Iterator it=set.iterator();
			
			while(it.hasNext()){
				Map.Entry m=(Map.Entry)it.next();
				
				ps=con.prepareStatement(query);
				ps.setString(1,m.getValue().toString());
				ps.setString(2, id);
				ps.setString(3,m.getKey().toString());
				ps.setInt(4, examid);
				
				ps.executeUpdate();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
//		boolean b = false;
//		Session s = sfact.openSession();
//		Transaction tr = s.beginTransaction();
//		
//		try
//		{
//			s.save(ref);
//			
//			tr.commit();
//			s.close();
//			
//			b = true;
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			return false;
//		}
//		
//		return b;
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