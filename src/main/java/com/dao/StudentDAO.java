package com.dao;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dto.Student;

public class StudentDAO 
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public StudentDAO() {
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
	
//	public boolean validateStudent(Student ref)
//	{
//		boolean b = false;
//		
//		try 
//		{
//			Optional<Student> opt = repository.findById(ref.getStudentid());
//			
//			if(opt.isPresent())
//			{
//				Student stud = opt.get();
////				if(stud.getStudusername().equals(ref.getStudusername()))
////				{
////					if(stud.getStudpassword().equals(ref.getStudpassword()))
////						b = true;
////				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			return false;
//		}
//		
//		return b;
//	}
//	
//	public boolean changePassword(Student ref, String newpass)
//	{
//		boolean b = false;
//		
//		try 
//		{
////			Student stud = repository.findStudentByUsernameAndPassword(ref.getStudusername(), ref.getStudpassword());
////			if(stud!=null)
////			{
////				int n = repository.updateStudentPassword(ref.getStudusername(), newpass);
////				if(n>0)
////					b = true;
////			}
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			return false;
//		}
//		
//		return b;
//	}
}
