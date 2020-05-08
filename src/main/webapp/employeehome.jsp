<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Employee - Home Page</title>
<link rel="stylesheet" type="text/css" href="/menubar.css">
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
<div class="maindiv">
<span style="font-size:30px;cursor:pointer;color:white;" onclick="openNav()">&#9776;</span>
<h1 style="text-align: center;color: white;font-size:20px;margin-top:-23px;"> Welcome <span style="color:white;"><%=user.toUpperCase() %></span></h1>
</div>

<div id="mySidenav" class="sidenav">
<a href="javascript:void(0)" class="closebtn" style="margin-top:-54px;" onclick="closeNav()">&times;</a>
<ul>
<li><a href="/emp/homeemp"><i class="fa fa-home"></i>Home</a></li>
<li><a href="/emp/defaultlist"><i class="fa fa-user-times"></i>Defaulters</a></li>
<li><a href="/emp/cards"><i class="fa fa-credit-card"></i>Re-activate cards</a></li>
<li class="dropdown"><a href="#"><i class="fa fa-user-times"></i>Due List</a>
<div class="dropdown-content">
<a href="/emp/duelessthree">Less than Three Months</a>
<a href="/emp/duelesssix">Between 3 to 6</a>
<a href="/emp/duelesstwelve">Between 6 to 12</a>
<a href="/emp/duegreatertwelve">Greater than 12 Months</a>
<a href="#">All Customers</a>
</div>
</li>
<li class="dropdown"><a href="#"><i class="fa fa-address-card-o" aria-hidden="true"></i>Contact Us</a>
<div class="dropdown-content">
<a href="#">phone:+(91)-8688292729</a>
<a href="#">Mail id:-autoidentification@gmail.com</a>
</div>
</li>
<li><a href="/"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
</ul>
</div>

<div align="center"   style="position:relative; right:0; left:0;padding-bottom: 40px;">
<h1 style="color: blue;font-size: 30px;">${message}</h1>
</div>


<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
</body>
</html>