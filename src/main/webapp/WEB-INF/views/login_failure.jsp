<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src='<c:url value="/resources/js/sweetalert2.all.js"/>' type='text/javascript'></script>
<script src='<c:url value="/resources/js/jquery.min.js"/>' type='text/javascript'></script>

<%
out.println("<script>");
out.println("$(document).ready(function(){");
out.println("swal ( 'Message From Server' ,  'User_ID or Password Incorrect !!!' ,"
        + "  'warning' );");
out.println("});");
out.println("</script>");
%>
<jsp:include page="/WEB-INF/views/index.jsp"></jsp:include>