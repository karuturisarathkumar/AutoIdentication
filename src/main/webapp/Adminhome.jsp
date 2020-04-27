<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	response.sendRedirect("/admin/");
}
%>
<div class="menubar">
<h1 style="text-align: center;color: white;"> Welcome <span style="color:white;"><%=user.toUpperCase() %></span></h1> 
<ul>
<li class="active"><a href="/admin/homeadmin"><i class="fa fa-home"></i>Home</a></li>
<li ><a href="#"><i class="fa fa-user-times"></i>Defaulter</a>
<div class="sub-menu-1">
<ul>
<li><a href="/admin/autocustlist">AutoDefaulters</a></li>
<li><a href="/admin/manualcustlist">ManualDefaulters</a></li>
<li><a href="/admin/list">Customers</a></li>
<li><a href="/admin/sixmonthlist">six months</a></li>
</ul>
</div>
</li>
<li ><a href="/admin/getemplist"><i class="fa fa-user"></i>NewEmployee</a></li>
<li ><a href="/admin/ativates"><i class="fa fa-universal-access"></i>Reactivation</a></li>
<li ><a href="#"><i class="fa fa-flag"></i>Report</a>
<div class="sub-menu-1">
<ul>
<li><a href="/admin/genRep">Over all report</a></li>
<li><a href="/admin/autodef">no.of AutoDefaulter</a></li>
<li><a href="#">no.of ManualDefaulter</a></li>
<li><a href="#">no.of Autowavers</a></li>
<li><a href="#">no.of validators</a></li>


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
</li>
</ul>
</div>


<div style="position:fixed; right:0; left:0; bottom: 5px;">
<h1 style="color: red;font-size: 30px;"><marquee>${message}</marquee></h1>
</div>
</body>
</html>















