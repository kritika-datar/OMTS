package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.TeacherDAO;

@Controller
public class TeacherController 
{
//	@Autowired
//	private TeacherDAO service;
	
//	@RequestMapping(value = "/loginTeacher")
//	public String loginTeacher(Teacher ref, HttpServletRequest httpServletRequest)
//	{
//		HttpSession hs = httpServletRequest.getSession(true);
//		
//		if(service.validateTeacher(ref))
//		{
////			hs.setAttribute("t);
//			return "index_teacher";
//		}
//		else
//			return "login_failure";
//	}
	
	@RequestMapping(value = "/index_teacher")
	public String indexTeacher()
	{
		return "index_teacher";
	}

}
