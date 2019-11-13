package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.LoginDAO;

@Controller
public class LoginController 
{
	private ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring.xml");
	private LoginDAO ldao = 
			 (LoginDAO) context.getBean("logindao");
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password, HttpServletRequest request)
	{
		HttpSession hs = request.getSession(true);
		
		System.out.println(ldao.validateUser(username,password).getType());
		if(ldao.validateUser(username,password).getType().equals("teacher"))
		{
//			System.out.println(loginService.validateUser(ref));
			hs.setAttribute("username", username);
			return "index_teacher";
		}
		else if(ldao.validateUser(username,password).getType().equals("student"))
		{
			hs.setAttribute("username", username);
			return "index_student";
		}
		else
		{
			return "login_failure";
		}
	}

}
