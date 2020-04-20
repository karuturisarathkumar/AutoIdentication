<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Employee - Home Page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
String username =(String) session.getAttribute("username");
if(username==null)
{
	response.sendRedirect("#");
}
%>
<div class="header1">
<h1 style="text-align: center"> Welcome <span style="color:Navy;"> <%=username.toUpperCase() %></span></h1> 
<ul>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
</ul>
</div>
</body>
</html>