<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Employee - Home Page</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%
String user =(String) session.getAttribute("userid");
if(user==null)
{
	response.sendRedirect("/emp/");
}
%>
<div class="menubar">
<h1 style="text-align: center;color: white"> Welcome <span style="color:white;"><%=user.toUpperCase() %></span></h1> 
<ul>
<li class="active"><a href="/emp/homeemp"><i class="fa fa-home"></i>Home</a></li>
<li ><a href="/emp/defaultlist"><i class="fa fa-user-times"></i>Defaulters</a></li>

<li ><a href="/emp/cards"><i class="fa fa-credit-card"></i>Re-activate cards</a></li>

<li ><a href="#"><i class="fa fa-user-times"></i>Due List</a>
<div class="sub-menu-1">
<ul>
<li><a href="/emp/duelessthree">Less than Three Months</a></li>
<li><a href="/emp/duelesssix">Between 3 to 6</a></li>
<li><a href="/emp/duelesstwelve">Between 6 to 12</a></li>
<li><a href="/emp/duegreatertwelve">Greater than 12 Months</a></li>
<li><a href="#">All Customers</a></li>
</ul>
</div>
</li>

<li ><a href="/"><i class="fa fa-power-off"></i>Logout</a></li>
<li ><a href="#"><i class="fa fa-phone"></i>contact us</a>
<div class="sub-menu-1">
<ul>
<li style="width: 250px;"><a href="#">phone:+(91)-8688292729</a></li>
<li><a href="#">Mail id:-karuturisarathkumar@gmail.com</a></li>
</ul>
</div>
<li ><a href="/admin/getlist"><i class="bi bi-envelope-fill"></i>Technical Issues</a></li>
</li>
</ul>
</div>
<div style="position:fixed; right:0; left:0; bottom: 5px;">
<h1 style="color: red;font-size: 30px;"><marquee>${message}</marquee></h1>
</div>
</body>
</html>