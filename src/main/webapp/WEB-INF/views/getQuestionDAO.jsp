<%@page import="com.dao.QuestionDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%-- <%@page import="com.UserDAO"%> --%>
<%
String question_no=request.getParameter("question_no");
String req=request.getParameter("req");
String set=(String)session.getAttribute("set");
String email=(String)session.getAttribute("email");
int examid = (Integer)session.getAttribute("examid");
//out.println(examid);
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
QuestionDAO qdao = (QuestionDAO)context.getBean("questiondao");

if(req!=null){
	if(req.equals("first")){
	String result=qdao.getQuestion(question_no,examid);
	out.print(result);
//	out.print(examid);
	}
	else{
		   String question_id=request.getParameter("question_id");
		    String answer=request.getParameter("answer");
		    LinkedHashMap lhm=(LinkedHashMap)session.getAttribute("all_answers");
		    
		    if(!answer.equals("undefined")){
		          
		          
		          if(lhm==null){
		              lhm=new LinkedHashMap();
		              lhm.put(question_id, answer);
		              session.setAttribute("all_answers", lhm);
		          }
		          else{
		              lhm.put(question_id, answer);
		              session.setAttribute("all_answers", lhm);
		          }
		    }
	
	}
}
else{
	String question_id=request.getParameter("question_id");
	String answer=request.getParameter("answer");
    LinkedHashMap lhm=(LinkedHashMap)session.getAttribute("all_answers");
	
	if(!answer.equals("undefined")){
		  
		  
		  if(lhm==null){
			  lhm=new LinkedHashMap();
			  lhm.put(question_id, answer);
			  session.setAttribute("all_answers", lhm);
		  }
		  else{
			  lhm.put(question_id, answer);
              session.setAttribute("all_answers", lhm);
		  }
	}
	

	String result=qdao.getQuestion(question_no,examid);
	out.print(result);

}
%>