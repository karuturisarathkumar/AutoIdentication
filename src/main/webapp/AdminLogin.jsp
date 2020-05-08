<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
function loginvalidation(){
	var userid=document.adminlogin.userId.value;
	var password=document.adminlogin.password.value;
	if(userid==""|| userid==null)
	{
		alert("Please enter the userid");
		document.getElementById('uId').style.borderColor = "red";		
		return false;
		 
	}
	if(password==""|| password==null)
	{
		alert("Please enter the password");
		document.getElementById('psd').style.borderColor = "red";		
		return false;
	}
}
</script>
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1" align="center">
<h1>Admin Login</h1>
${message }
</div>
<div align="center">
<div class="forms-data">
<form:form name="adminlogin" action="/admin/logadmin" method="post" modelAttribute="adminlogin" onsubmit="return loginvalidation()">
<table>
<tr>
<td>UserId:</td>
<td>
<form:input path="userId"  id="uId" class="form-control" onfocus="validateuid()"/>
<br>
<a href="forgetUId" style="font-size:14px;">ForgotUserid</a>
</td>
</tr>
<tr>
<td>Password:</td>
<td><form:password path="password" id="psd" class="form-control" onfocus="validatepsd()"/>
<br>
<a href="forgetpwd" style="font-size:14px;">ForgotPassword</a>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login" class="formsubmitbutton" />
</tr>
</table>
</form:form>
New Admin?<a href="/admin/regadmin" style="color:yellow;"> SignUp</a>
</div>
<a href="/"  style="color:black;">Home</a>
</div>
<script type="text/javascript">
function validateuid(){
	document.getElementById('uId').style.borderColor = "grey";
}
function validatepsd(){
	document.getElementById('psd').style.borderColor = "grey";
}
</script>
</body>
</html>