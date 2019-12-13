<%@page import="com.dto.Exam"%>
<%@page import="com.dao.ExamDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Mock Tests</title>
    </head>
    <body>
         <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
<!--                 <div class="row">
                    <div class="col-sm-6">
                        <h2> Questions By You</h2><br>
                    </div>
                </div>
 -->            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                    	<th></th>
                        <th>Exam Title</th>
                        <th>Course</th>
                        <th>Semester</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                  <%
                   	String username = (String)session.getAttribute("username");
                  
                  	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                  	
                  	ExamDAO exam = (ExamDAO)context.getBean("examdao");
                    List<Exam> lst = exam.showExamsForTeachers(username);
                    
                    if(lst != null)
                    {
						for(Exam ex : lst)
                    	{
                     %>
                     <form action="viewquestionsforexam" method="post">
                    	<tr>
                    		<td><input type="" value="<%=ex.getExamid() %>" name="examid" style="border:none"></td>
                    		<td><%=ex.getTitle() %></td>
                    		<td><%=ex.getCourse() %></td>
                    		<td><%=ex.getSemester() %></td>
                    		<td><button class="btn btn-primary pull-right">View</button></td>
                    	</tr> 
                     </form>
                    
                    <%
                     	}
                    }  %>
                    <!-- /* ApplicationContext context = 
           			new ClassPathXmlApplicationContext("spring.xml");
                    
                            QuestionDAO dao = (QuestionDAO)
                            		context.getBean("questdao");
                            
                            List<Question> lst = 
dao.getAllUnansweredQuestionsForCustomer((String)
                            session.getAttribute("userid"));

                            if(lst != null)
                            {
                            for (Question qs : lst) { */
                            	
                            	
                    %> -->
<%--                     <tr>

                        <td><%=qs.getQuestionTitle()></td>

                        <td><%=qs.getQuestionDesc()></td>
                        <td>
                            <%=qs.getPostedDate()>
                        </td>
                     </tr>
 --%>               <%--  <%}}%> --%>
               </tbody>
            </table>
        </div>
         </div>

                
            <div class="clearfix">
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item "><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        
 
        
    </body>
</html>
