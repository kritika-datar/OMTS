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
	
//	@RequestMapping(value = "/takeexam", method = RequestMethod.POST)
//	public String takeexam(@RequestParam(name = "examid")int examid, HttpServletRequest request)
//	{
//		HttpSession httpSession = request.getSession(true);
//		httpSession.setAttribute("examid", examid);
//		String username = (String)httpSession.getAttribute("username");
//		
////		ModelAndView model = new ModelAndView();
////		model.addObject("exams", qdao.getAllQuestionsByExamId(examid));
////		model.setViewName("mock_tests");
//		
//		return "questionforexam";
//	}
	
	@RequestMapping(value = "/questionforexam", method = RequestMethod.POST)
	public String questionforexam(@RequestParam(name = "examid")int examid, HttpServletRequest request)
	{
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("examid", examid);
		int e = (Integer)httpSession.getAttribute("examid");
		System.out.println(e);
		String username = (String)httpSession.getAttribute("username");
		
//		ModelAndView model = new ModelAndView();
//		model.addObject("exams", qdao.getAllQuestionsByExamId(examid));
//		model.setViewName("mock_tests");
		
		return "questionforexam";
	}
	
	@RequestMapping(value = "/getQuestionDAO", method = RequestMethod.GET)
	public String getQuestionDAO(@RequestParam(name = "question_no")int question_no, @RequestParam(name = "req")String req, HttpServletRequest request)
	{
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("question_no", question_no);
		httpSession.setAttribute("req", req);
		
		return "getQuestionDAO";
	}
	
	@RequestMapping(value = "/getQuestDAO", method = RequestMethod.GET)
	public String getQuestDAO(@RequestParam(name = "question_no")int question_no, @RequestParam(name = "question_id")int question_id, @RequestParam(name = "answer")String answer, HttpServletRequest request)
	{
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("question_no", question_no);
		httpSession.setAttribute("question_id", question_id);
		httpSession.setAttribute("answer", answer);
		
		return "getQuestionDAO";
	}
	
	@RequestMapping(value = "/getQDAO", method = RequestMethod.GET)
	public String getQDAO(@RequestParam(name = "question_no")int question_no, @RequestParam(name = "question_id")int question_id, @RequestParam(name = "answer")String answer, @RequestParam(name = "req")String req, HttpServletRequest request)
	{
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("question_no", question_no);
		httpSession.setAttribute("question_id", question_id);
		httpSession.setAttribute("answer", answer);
		httpSession.setAttribute("req", req);
		
		return "getQuestionDAO";
	}
}
