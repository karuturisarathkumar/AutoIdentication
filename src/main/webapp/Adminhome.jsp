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
<li ><a href="/admin/getemplist">list of employees</a></li>
<li ><a href="#"></a></li>
<li ><a href="#"></a></li>
<li ><a href="/admin/logout">Logout</a></li>
</ul>
</div>


<div align="center">
<table border="2">
<tr>
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
</tr>
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