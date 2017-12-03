<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="selectId" method="post">
	<input type="submit" value="ver listado">
</form>
<% 
 User user = (User)request.getAttribute("selectByNombre");
 pageContext.setAttribute("user", user);
%>
<br/>
<table border="1">
<thead>
	<tr>
		<td>Nombre</td>
		<td>Apellido</td>
	</tr>
</thead>
<tbody>
<%

if(null != user){
	out.println("<tr>");
	out.println("<td>");
	out.println(user.getNombre());
	out.println("</td>");
	out.println("<td>");
	out.println(user.getApellido());
	out.println("</td>");
	out.println("</tr>");
	
}
%>
</tbody>
</table>







</body>
</html>