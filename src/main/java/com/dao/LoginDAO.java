package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dto.Login;

public class LoginDAO 
{
	private HibernateTemplate htemplate;
	private SessionFactory sfact;
	
	public LoginDAO() {
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

	public Login validateUser(String username, String password)
	{
		Login log = null;
		
		try 
		{
			log = htemplate.execute(new HibernateCallback<Login>() {
				
				@SuppressWarnings("unchecked")
				@Override
				public Login doInHibernate(Session session) throws HibernateException {
					
					List<Login> lst = null;
					
					Query q = session.createQuery("FROM Login L where L.username=:username AND L.password=:password");
					
					q.setParameter("username", username);
					q.setParameter("password", password);
					
					lst = q.list();
					
					if(lst.size()>0)
					{
						return lst.get(0);
					}
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
		
		return log;
	}
}
