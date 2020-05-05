<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="padding-top: 150px;">
<form:form action="issue" modelAttribute="logissue" method="post">
<table>
<tr>
<td style="color: black"><b>Role</b></td>
<td>
<form:select path="role">
<form:option value="admin">Admin</form:option>
<form:option value="employee">Employee</form:option>
</form:select>
</td>
</tr>


<tr>
<td style="color: black"><b>UserId</b></td>
<td><form:input path="userId"/></td>
</tr>

<tr>
<td style="color: black"><b>Issue</b></td>
<td><form:input path="issue"/></td>
</tr>

<tr>
<td style="color: black"><b>Description</b></td>
<td><form:input path="description"/></td>
</tr>

</table>

<input type="submit" value="submit">
</form:form>
</div>
</body>
<%

RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
rd.include(request, response);

%>
</html>