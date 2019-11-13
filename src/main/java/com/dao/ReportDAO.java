package com.dao;

import java.util.List;

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
	public List<Report> getStudentScoreById(int studid)
	{
		List<Report> lst = null;
		
		try 
		{
//			lst = repository.findReportById(studid);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return lst;
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
