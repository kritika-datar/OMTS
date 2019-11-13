package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController 
{
	@RequestMapping(value = "/")
	public String init()
	{
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value = "/logout")
	public String logoutCust()
	{
		return "logout"; 
	}
	
//	@RequestMapping(value = "/login")
//	public String login()
//	{
//		
//	}

}
