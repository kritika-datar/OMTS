package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dto.Report;

public class ReportDAO 
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public ReportDAO() {
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
	public int getStudentScoreById(String username, int examid)
	{
		int x = 0;
		String query="select * from answer where username=? and examid=? ";
		
		String URL="localhost:3306/";
		String DATABASE_NAME="omts";
		String USERNAME="root";
		String PASSWORD="root";
		
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://"+URL+DATABASE_NAME,USERNAME,PASSWORD);

			PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setInt(2, examid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String a = rs.getString("recordedanswer");
				int b = rs.getInt("questionid");
				String q = "select * from question where examid=? and (correctanswer=? and questionid=?)";
				
				PreparedStatement pst = con.prepareStatement(q);
				pst.setInt(1, examid);
				pst.setString(2, a);
				pst.setInt(3, b);
				
//				pst.execute();
				
				ResultSet rst = pst.executeQuery();
				
				while(rst.next())
				{
					x++;
				}
//					x++;
			}
			
			String str = "insert into score(username,examid,score) values(?,?,?)";
			PreparedStatement pstr = con.prepareStatement(str);
			pstr.setString(1, username);
			pstr.setInt(2, examid);
			pstr.setInt(3, x);
			
			pstr.execute();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return x;
	}
	
	public List<Report> getScoreByQuestion(int questionid)
	{
		List<Report> lst = null;
		
		try 
		{
//			lst = repository.findReportByQuestionId(questionid);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return lst;
	}
	
	public List<Object[]> findAllReports()
	{
		List<Object[]> lst = null;
		
		try 
		{
//			lst = repository.findAllReports();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return lst;
	}

}
