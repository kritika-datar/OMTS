package com.controller;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ExamDAO;
import com.dto.Answer;
import com.dto.Exam;
import com.dto.Login;
import com.dto.Question;
import com.dto.Student;

@Controller
public class ExamController 
{
	private ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring.xml");
	private ExamDAO edao = 
			 (ExamDAO) context.getBean("examdao");
	
	@RequestMapping(value = "/addExam")
	public String addExam(Exam ref, HttpServletRequest request)
	{
		HttpSession httpSession = request.getSession(true);
		
		String str = (String) httpSession.getAttribute("username");
		Login log = new Login(str);
		log.setUsername(str);
		
		Exam exam = new Exam();
		exam.setTitle(ref.getTitle());
		exam.setCourse(ref.getCourse());
		exam.setSemester(ref.getSemester());
		exam.setQdoc(ref.getQdoc());
		exam.setLogin(log);
		
		if(edao.saveExam(exam))
			return "exam_success";
		else
			return "exam_failure";
	}
	
	@RequestMapping(value = "/upload_exam")
	public String upload_ques()
	{
		return "upload_exam";
	}
	
//	@RequestMapping(value = "/submitexam", method = RequestMethod.POST)
//	public String submitexam(@RequestParam("qid")int qid,HttpServletRequest request)
//	{
//		HttpSession session = request.getSession(true);
//		
//		String str = (String)session.getAttribute("username");
//		Login log = new Login();
//		log.setUsername(str);
//		
//		Student stu = new Student();
//		stu.setLogin(log);
//		
//		Question quest = new Question();
//		quest.setQuestionid(qid);
//		
//		Answer ans = new Answer();
//		ans.setStudent(stu);
//		ans.setQuestion(quest);
//		ans.setAnswer(answer);
//		
//	}
	
	@RequestMapping(value = "/mock_tests")
	public ModelAndView mock_tests(HttpServletRequest httpServletRequest)
	{
		HttpSession httpSession = httpServletRequest.getSession();
		
		ModelAndView model = new ModelAndView();
		model.addObject("exams", edao.showExamsForTeachers((String) httpSession.getAttribute("username")));
		model.setViewName("mock_tests");
		return model;
	}
	
//	public String viewTeacherExams(Teacher ref, HttpServletRequest request)
//	{
//		HttpSession httpSession = request.getSession();
//		
//		String str = (String)httpSession.getAttribute("username");
//		
//		
//	}

}
