package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDAO;

@Controller
public class QuestionController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	QuestionDAO qdao = (QuestionDAO)context.getBean("questiondao");
	
	@RequestMapping(value = "/viewquestionsforexam", method = RequestMethod.POST)
	public String viewquestionsforexam(@RequestParam(name = "examid")int examid, HttpServletRequest request)
	{
		HttpSession session = request.getSession(true);
		session.setAttribute("examid", examid);
		System.out.println(examid);
		
//		if(qdao.getAllQuestionsByExamId(examid)!=null)
//		{
			return "questionforid";
//		}
//		else
//			return "";
	}
	
	@RequestMapping(value = "/takeexam", method = RequestMethod.POST)
	public String takeexam(@RequestParam(name = "examid")int examid, HttpServletRequest request)
	{
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("examid", examid);
		String username = (String)httpSession.getAttribute("username");
		
//		ModelAndView model = new ModelAndView();
//		model.addObject("exams", qdao.getAllQuestionsByExamId(examid));
//		model.setViewName("mock_tests");
		
		return "questionforexam";
	}
}
