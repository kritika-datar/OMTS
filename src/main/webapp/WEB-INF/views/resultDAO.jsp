<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.dao.AnswerDAO"%>
<%@page import="java.util.LinkedHashMap"%>
<%-- <%@page import="com.UserDAO"%>
 --%>
 <%
String username=(String)session.getAttribute("username");
//out.println(username);
LinkedHashMap lhm=(LinkedHashMap)session.getAttribute("all_answers");
//out.println(lhm);
int examid = (Integer)session.getAttribute("examid");
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
AnswerDAO qs = (AnswerDAO)context.getBean("answerdao");
qs.saveAnswers(examid, username, lhm);
response.sendRedirect("warnresult");
%>