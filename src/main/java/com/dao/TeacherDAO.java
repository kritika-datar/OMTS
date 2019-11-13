package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class TeacherDAO
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public TeacherDAO() {
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
	
//	public boolean validateTeacher(Teacher ref)
//	{
//		boolean b = false;
//		
//		try 
//		{
//			Optional<Teacher> opt = repository.findById(ref.getTeacherid());
//			
//			if(opt.isPresent())
//			{
//				Teacher teach = opt.get();
////				if(teach.getUsername().equals(ref.getUsername()))
////				{
////					if(teach.getPassword().equals(ref.getPassword()))
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
//	public boolean changePassword(Teacher ref, String newpass)
//	{
//		boolean b = false;
//		
//		try 
//		{
////			Teacher teach = repository.findTeacherByUsernameAndPassword(ref.getUsername(), ref.getPassword());
////			if(teach!=null)
////			{
////				int n = repository.updateTeacherPassword(ref.getPassword(), newpass);
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
//	
//	public boolean uploadQuestions()
//	{
//		boolean b = false;
//		
//		return b;
//	}
//
}