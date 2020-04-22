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
<li><a href="#">AutoDefaulters</a></li>
<li><a href="#">ManualDefaulters</a></li>
<li><a href="#">six months</a></li>
</ul>
</div>
</li>
<li ><a href="/admin/getemplist"><i class="fa fa-user"></i>NewEmployee</a></li>
<li ><a href="#"><i class="fa fa-universal-access"></i>Reactivation</a></li>
<li ><a href="/"><i class="fa fa-power-off"></i>Logout</a></li>
<li ><a href="#"><i class="fa fa-phone"></i>contact us</a></li>
<!-- <li ><a href="/admin/getemplist">list of employees</a></li>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
<li ><a href="/admin/logout">Logout</a></li> -->
</ul>
</div>
<div>
<h1 style="color: red;font-size: 30px;"><marquee>${message}</marquee></h1>
</div>

<div align="center">
<table border="2"  style="background-color: yellow;">
<!-- <tr>
<th>userid</th>
<th>firstname</th>
<th>lastname</th>
<th>age</th>
<th>gender</th>
<th>mobile</th>
<th>city</th>
<th>state</th>
<th>password</th>
<th>status</th>
</tr> -->
<c:forEach items="${employeelist}" var="employee">

 <tr>
      <td>${employee.userId}</td>
       <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
         <td>${employee.age}</td>
          <td>${employee.gender}</td>
           <td>${employee.contactNumber}</td>
           <td>${employee.city}</td>
           <td>${employee.state}</td>
           <td>${employee.password}</td>
           <td>${employee.status}<a href="/admin/activate?userid=${employee.userId}" style="color: yellow;">activate</a></td>
           <%-- <td> <a href="/student/applycourse?couresid=${course.courseid}" style="color: yellow;">Take This Course</a> </td> --%>




</c:forEach>

</table>





</div>















</body>
</html>