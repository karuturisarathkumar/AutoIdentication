<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="/AdminStyle.css">
</head>
<body>
<div class="header1">
<h1>Admin Login</h1>
</div>
<div align="center">
<div class="forms-data">
<form:form>
<table>
<tr>
<td>UserId:</td>
<td>
<form:input path="UserId" id="userId" class="form-control"/>
</td>
</tr>

<tr>
<td>Password:</td>
<td><form:password path="Password" id="password" class="form-control"/>
</td>
</tr>
<tr>

<td colspan="2" align="center"><input type="submit" value="Login" class="formsubmitbutton" />

</tr>
</table>
</form:form>
New Admin<a href="" style="color:yellow;"> SignUp</a>
</div>
<a href="/">Home</a>
</div>
</body>
</html>