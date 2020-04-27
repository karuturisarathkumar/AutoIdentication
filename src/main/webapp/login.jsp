<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script type="text/javascript">
function emploginvalidation(){
	var userid=document.emplogin.userId.value;
	var password=document.emplogin.password.value;
	if(userid==""|| userid==null)
	{
		alert("Please enter the userid");
		document.getElementById('UId').style.borderColor = "red";
		return false;
		 
	}
	if(password==""|| password==null)
	{
		alert("Please enter the password");
		document.getElementById('Pwd').style.borderColor = "red";
		return false;
	}
}
</script>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<body>
<div class="header1" align="center">
<h1>Bank Employee - Login</h1>
${message }
</div>
<div align="center">
<div class="forms-data">
<form:form name="emplogin"  action="/emp/verifylogin" method="post" modelAttribute="bankemployeelogin" onsubmit="return emploginvalidation()" style="margin-top:50px;margin-left:30px;">
<table>
<tr>
<td style="color: white">User Id</td>
<td>
<form:input path="userId" id="UId" class="form-control" onfocus="validateuid()"/>
<br>
<a href="forgetUserId" style="font-size:14px;">ForgotUserid</a>
<form:errors path="userId" id="UId" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td style="color: white">Password</td>
<td>
<form:input path="password" id="Pwd" class="form-control" onfocus="validatepwd()"/>
<br>
<a href="forgetpassword" style="font-size:14px;">ForgotPassword</a>
<form:errors path="password" id="Pwd" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login" class="formsubmitbutton" />
</tr>
</table>
</form:form>
New Bank Employee?<a href="/emp/register" style="color:white;">Registration</a>
</div>
<a href="/" style="color:white;">Home Page</a>
</div>
<script type="text/javascript">
function validateuid(){
	document.getElementById('UId').style.borderColor = "grey";
}
function validatepwd(){
	document.getElementById('Pwd').style.borderColor = "grey";
}
</script>
</body>
</html>