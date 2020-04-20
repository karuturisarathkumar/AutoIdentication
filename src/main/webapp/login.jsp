<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<body>
<div class="header1">
<h1>Bank Employee - Login</h1>
</div>
<div align="center">
<div class="forms-data">
<form:form  action="#" method="post" modelAttribute="#" style="margin-top:50px;margin-left:30px;">
<table>
<tr>
<td>User Id</td>
<td>
<form:input path="userid" class="form-control"/>
<br>
<form:errors path="userid" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Password</td>
<td>
<form:input path="password" class="form-control"/>
<br>
<form:errors path="password" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login" class="formsubmitbutton" />
</tr>
</table>
</form:form>
New Bank Employee<a href="/registration" style="color:Navy;">Registration</a>
</div>
<a href="/" style="color:Navy;">Home Page</a>
</div>
</body>
</html>