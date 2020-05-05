<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/menubar.css">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<table border="2"  style="margin-top:25px;">
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
           <td>
           <button class="button"><a href="/admin/activate?userid=${employee.userId}" style="color: red;">activate</a>
           </button>
           </td>
           
</c:forEach>

</table>
</div>

<%

RequestDispatcher rd = request.getRequestDispatcher("sampleadminhome.jsp");
rd.include(request, response);

%>

</body>
</html>