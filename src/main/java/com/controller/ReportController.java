package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ReportDAO;

@Controller
public class ReportController 
{
	private ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring.xml");
	private ReportDAO edao = 
			 (ReportDAO) context.getBean("reportdao");
	
	@RequestMapping(value = "/resultDAO")
	public String resultDAO(HttpServletRequest request)
	{
		HttpSession session = request.getSession(true);
		int examid = (Integer)session.getAttribute("examid");
		return "resultDAO";
	}
}
