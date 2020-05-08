<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/menubar.css">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<div id="mySidenav" class="sidenav">
<a href="javascript:void(0)" class="closebtn" style="margin-top:-54px;" onclick="closeNav()">&times;</a>  
  <ul>
 <!--  <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i>View Profile</a></li>
  <li><a href="#"><i class="fa fa-key" aria-hidden="true"></i>change password</a></li> -->
  <li><a href="/admin/homeadmin"><i class="fa fa-home"></i>Home</a></li>
  <li class="dropdown"><a href="#"><i class="fa fa-users" aria-hidden="true"></i>Defaulter</a>
  <div class="dropdown-content">
    <a href="/admin/autocustlist">AutoDefaulters</a>
    <a href="/admin/manualcustlist">ManualDefaulters</a>
    <a href="/admin/list">Customers</a>
    <a href="/admin/sixmonthlist">six months</a>
  </div>
  </li>
  <li><a href="/admin/getemplist"><i class="fa fa-user" aria-hidden="true"></i>New Employee</a></li>
  <li class="dropdown"><a href="#"><i class="fa fa-credit-card" aria-hidden="true"></i>Cards</a>
  <div class="dropdown-content">
    <a href="/admin/ativates"><i class="fa fa-universal-access"></i>Reactivation</a>
    <a href="/admin/deactivates"><i class="fa fa-ban"></i>deactivation</a>    
  </div>
  </li>
  <li class="dropdown"><a href="#"><i class="fa fa-flag"></i>Report</a>
  <div class="dropdown-content">
  <a href="/admin/genRep">Over all report</a>
  <a href="/admin/autocustlist">no.of AutoDefaulter</a>
  <a href="/admin/manualcustlist">no.of ManualDefaulter</a>
  <a href="/admin/DefList">no.of Defalters</a>
  <a href="/admin/activationList">no.of Re_activations</a>
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



<div align="center"   style="position:fixed; right:0; left:0; bottom: 5px;padding-bottom: 350px;">
<h1 style="color: blue;font-size: 30px;">${message}</h1>
</div>
<%
String user =(String) session.getAttribute("userid");
if(user==null)
{
	response.sendRedirect("/admin/");
}
%>
<div class="maindiv">
<span style="font-size:30px;cursor:pointer;color:white;" onclick="openNav()">&#9776;</span>
<h1 style="text-align: center;color: white;font-size:20px;margin-top:-23px;"> Welcome <span style="color:white;"><%=user.toUpperCase() %></span></h1>
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