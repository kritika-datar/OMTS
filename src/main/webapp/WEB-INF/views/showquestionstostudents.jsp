<%@page import="java.sql.Timestamp"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.dto.Answer"%>
<%@page import="com.dao.AnswerDAO"%>
<%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.dto.Expert"%>
 --%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--         <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
 -->        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<!--         <script src="/WEB-INF/views/jquery-1.11.3.js"></script>
 -->        <title>JSP Page</title>
    </head>
    <body onload="startTimer()">
         <div class="container">
        <div class="table-wrapper">
           <!--  <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2> Answers Posted By You</b></h2>
                    </div>
                </div>
            </div> -->
            <table class="table table-striped table-hover">
                <!-- <thead>
                    <tr>
                        <th>Question Title</th>
                        <th>Question Description</th>
                        <th>Your Answer</th>
                    </tr>
                </thead> -->
                
                
                <tbody>
                    <%
                    
                    String username = (String)session.getAttribute("username");
                    
                  	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                  	
                  	QuestionDAO qs = (QuestionDAO)context.getBean("questiondao");
                    
                  	int examid = (Integer)session.getAttribute("examid");
                  	List<Question> lst = qs.getAllQuestionsByExamId(examid);
                    
                    
                	/* ApplicationContext context = 
                	new ClassPathXmlApplicationContext("spring.xml");
                    
QuestionDAO dao = (QuestionDAO)context.getBean("questdao");

AnswerDAO ado = (AnswerDAO)context.getBean("ansdao");
                            
List<Object[]> anslist = ado.getAllQuestionsAndAnswersByExpert(
                                    (String)session.getAttribute("userid"));

                            if(anslist != null)
                            {
                            for (Object[] arr : anslist) {
                            	Answer ans = (Answer)arr[0]; */
                            	/*
                            	ans.setId((Integer)arr[0]);
                            	ans.setAnsDesc((String)arr[1]);
                            	ans.setPostedDate((Timestamp)arr[2]);
                            	ans.setQuest((Question)arr[3]);
                            	ans.setExp((Expert)arr[4]);
                            	*/
                           // Question qs = ans.getQuest();
                            	/* Question qs = (Question) arr[1]; */
                     %>
                     
                     <script>
    var question_no=1;
    var question_id=0;
    var max_questions=15;
    
    var timer=15;
    var min=0;
    var sec=0;
    
    window.onbeforeunload = function() { if(question_no!=max_questions){return "Warning: Your work will be lost!";} };

    function startTimer(){
    	min=parseInt(timer/60);
    	sec=parseInt(timer%60);

    	if(timer<1){
            window.location="/OMTS/src/main/webapp/WEB-INF/views/resultDAO.jsp";
        }
    		
    	document.getElementById("time").innerHTML = "<b>Time Left: </b>"+min.toString()+":"+sec.toString();
    	timer--;
    	setTimeout(function(){ startTimer(); }, 1000);
//    	document.getElementById("qno").innerHTML = question_no;
    }
    
    $(document).ready(function(){
    	console.log( "ready!" );
        $.get('/src/main/webapp/WEB-INF/views/getQuestionDAO.jsp?question_no='+question_no+'&req=first',function(data,status){
            var obj=JSON.parse(data);
            question_id=obj.id;
            $('#question').html('<b>Question '+question_no+': </b><br/>'+obj.question);
            $('#a').html('<b>A:</b><input type="radio" name="answer" value="A">'+obj.a);
            $('#b').html('<b>B:</b><input type="radio" name="answer" value="B">'+obj.b);
            $('#c').html('<b>C:</b><input type="radio" name="answer" value="C">'+obj.c);
            $('#d').html('<b>D:</b><input type="radio" name="answer" value="D">'+obj.d);
            $('#qno').html(' '+question_no);
        });
        
        if(question_no==1){
        	$('#back').hide();
//        	document.getElementById("qno").innerHTML = question_no;
        }
        else{
        	$('#back').show();
        }
        
        if(question_no==max_questions){
            $('#next').hide();
        }
        else{
            $('#next').show();
        }
        
        if(question_no!=max_questions){
            $('#submit').hide();
        }
        else{
            $('#submit').show();
        }
        
        $('#next').click(function(){
            var answer=$('input[name=answer]:checked').val();
            var s=$('input[name=answer]:checked').size();
        	
            if(s==0){
        		alert("Please select answer for this question");
        	}
        	else{
        	question_no++;
        	$.get('getQuestionDAO.jsp?question_no='+question_no+'&question_id='+question_id+'&answer='+answer,function(data,status){
                var obj=JSON.parse(data);
                question_id=obj.id;
                $('#question').html('<b>Question '+question_no+': </b><br/>'+obj.question);
                $('#a').html('<b>A:</b><input type="radio" name="answer" value="A">'+obj.a);
                $('#b').html('<b>B:</b><input type="radio" name="answer" value="B">'+obj.b);
                $('#c').html('<b>C:</b><input type="radio" name="answer" value="C">'+obj.c);
                $('#d').html('<b>D:</b><input type="radio" name="answer" value="D">'+obj.d);
            });
        	
        	if(question_no==1){
                $('#back').hide();
            }
            else{
                $('#back').show();
            }
            
            if(question_no==max_questions){
                $('#next').hide();
            }
            else{
                $('#next').show();
            }
            
            if(question_no!=max_questions){
                $('#submit').hide();
            }
            else{
                $('#submit').show();
            }
        	}
        });
        
        $('#submit').click(function(){
        	   var answer=$('input[name=answer]:checked').val();
               var s=$('input[name=answer]:checked').size();
               
               if(s==0){
                   alert("Please select answer for this question");
               }
               else{
            	   $.post('getQuestionDAO.jsp?question_no='+question_no+'&question_id='+question_id+'&answer='+answer+"&req=last");
            	   window.location='resultDAO.jsp';
               }
        });
        
        
        $('#back').click(function(){
            question_no--;
            var answer=$('input[name=answer]:checked').val();
            
            $.get('getQuestionDAO.jsp?question_no='+question_no+'&question_id='+question_id+'&answer='+answer,function(data,status){
                var obj=JSON.parse(data);
                question_id=obj.id;
                $('#question').html('<b>Question '+question_no+': </b><br/>'+obj.question);
                $('#a').html('<b>A:</b><input type="radio" name="answer" value="A" required>'+obj.a);
                $('#b').html('<b>B:</b><input type="radio" name="answer" value="B">'+obj.b);
                $('#c').html('<b>C:</b><input type="radio" name="answer" value="C">'+obj.c);
                $('#d').html('<b>D:</b><input type="radio" name="answer" value="D">'+obj.d);
            });
            
            if(question_no==1){
                $('#back').hide();
            }
            else{
                $('#back').show();
            }
            
            if(question_no==max_questions){
                $('#next').hide();
            }
            else{
                $('#next').show();
            }
            
            if(question_no!=max_questions){
                $('#submit').hide();
            }
            else{
                $('#submit').show();
            }
        });
        
     });

    </script>
                     
                     <%-- <%
                     	out.println(question_no);
                     %> --%>
    <div id="section">
        <p id="time"></p>
        <p id="test"></p>
        <br/>
        <p id ="qno"></p>
        <p id="question"></p><br/>
        <p id="a"></p>
        <p id="b"></p>
        <p id="c"></p>
        <p id="d"></p>
        
        <br/>
        <button id="next">Next</button>&nbsp;
        <button id="submit">Submit</button>
            
    </div>
                     
                     
                   <%--   <form action="submitexam" method="post">
                    <%
                    if(lst != null)
                    {
						for(Question ex : lst)
                    	{
                     %>
                     
                    	<tr>
                    		<input type="hidden" name="qid" value="<%=ex.getQuestionid() %>">
                    		<label><%=ex.getQuestion() %></label>
                    		<div class="radio">
  								<label><input type="radio" name="<%=ex.getQuestionid() %>" value="optiona" ><%=ex.getOptiona() %></label>
							</div>
							<div class="radio">
  								<label><input type="radio" name="<%=ex.getQuestionid() %>" value="optionb"><%=ex.getOptionb() %></label>
							</div>
							<div class="radio">
  								<label><input type="radio" name="<%=ex.getQuestionid() %>" value="optionc"><%=ex.getOptionc() %></label>
							</div>
							<div class="radio">
  								<label><input type="radio" name="<%=ex.getQuestionid() %>" value="optiond"><%=ex.getOptiond() %></label>
							</div>
							                    		
                    	</tr> 
                    
                    <%
                     	}
                    }  %>
                    
                    <tr><button class="btn btn-primary pull-right">Submit</button></tr>
                    
                    </form> --%>
                     <%-- <tr>

                        <td><%=qs.getQuestionTitle()%></td>

                        <td><%=qs.getQuestionDesc()%></td>
                        <% if(ans != null) { %>
                        <td><%=ans.getAnsDesc()%> <br> <%=ans.getPostedDate()%> </td>
                        <%} %>
                    </tr>
                <%}}%> --%>

                </tbody>
            </table>
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
        </div>
    </div>
    
        
    </body>
</html>
