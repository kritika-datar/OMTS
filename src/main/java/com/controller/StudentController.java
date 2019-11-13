package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.StudentDAO;
import com.dto.Student;

@Controller
public class StudentController 
{
//	@Autowired
//	public StudentDAO service;
	
//	@RequestMapping(value = "/index_student")
//	public String studentLogin(Student ref, HttpServletRequest request)
//	{
//		HttpSession httpSession = request.getSession(true);
//		
//		if(service.validateStudent(ref))
//		{
//			httpSession.setAttribute("username", ref.getStudname());
//			return "index_student";
//		}
//		else
//		{
//			return "login_failure";
//		}
//	}
//
}
