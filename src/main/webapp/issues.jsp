<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div  align="center" >
<div class="forms-data">
<form:form action="issue" modelAttribute="logissue" method="post">
<table>
<tr>
<td style="color: black"><b>Role</b></td>
<td>
<form:select path="role">
<form:option value="admin" class="form-control">Admin</form:option>
<form:option value="employee" class="form-control">Employee</form:option>
</form:select>
</td>
</tr>


<tr>
<td style="color: black"><b>UserId</b></td>
<td><form:input path="userId" class="form-control"/></td>
</tr>

<tr>
<td style="color: black"><b>Issue</b></td>
<td><form:input path="issue" class="form-control"/></td>
</tr>

<tr>
<td style="color: black"><b>Description</b></td>
<td><form:input path="description" class="form-control"/></td>
</tr>

</table>

<input type="submit" value="submit">
</form:form>
</div>
</div>
</body>
<%

RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
rd.include(request, response);

%>
</html>