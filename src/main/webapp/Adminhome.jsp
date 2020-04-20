<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Employee - Home Page</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String user =(String) session.getAttribute("userid");
if(user==null)
{
	response.sendRedirect("/admin/");
}
%>
<div class="header1">
<h1 style="text-align: center"> Welcome <span style="color:Navy;"><%=user.toUpperCase() %></span></h1> 
<ul>
<li ><a href="#">Register customer</a></li>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
</ul>
</div>
</body>
</html>