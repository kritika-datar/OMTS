
<%@page import="com.dao.ReportDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warn Result</title>
    </head>
    <body>
       <%
   		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		ExamDAO dao = (ExamDAO)context.getBean("examdao");
        String username = (String)session.getAttribute("username");
		ReportDAO rdao = (ReportDAO)context.getBean("reportdao");
		int examid = (Integer)session.getAttribute("examid");
		int score = rdao.getStudentScoreById(username, examid);
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
        out.println("<script>");
        out.println("$(document).ready(function(){");
        out.println("swal ( 'Your Score is' ,  '"+score+" !!!' ,"
                + "  'warning' );");
        out.println("});");
        out.println("</script>");
%>
<jsp:include page="/WEB-INF/views/index_student.jsp"></jsp:include>

    </body>
</html>
