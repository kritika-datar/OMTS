<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.dao.AnswerDAO"%>
<%@page import="java.util.LinkedHashMap"%>
<%-- <%@page import="com.UserDAO"%>
 --%>
 <%
String id=(String)session.getAttribute("email");
LinkedHashMap lhm=(LinkedHashMap)session.getAttribute("all_answers");
int examid = (Integer)session.getAttribute("examid");
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
AnswerDAO qs = (AnswerDAO)context.getBean("answerdao");
qs.saveAnswers(examid, id, lhm);
session.invalidate();
response.sendRedirect("index_student.jsp");
%>