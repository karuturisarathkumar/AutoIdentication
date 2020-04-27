<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function formvalidation()
{	
	 var userid = document.emppwd.userId.value;	 
	 var Answer = document.emppwd.answer.value;
	 if(userid ==""){
		 alert("please enter userid");
		 document.getElementById('userId').style.borderColor = "red";
		 return false;
		 }
	 
	 if(Answer ==""){
		 alert("please enter answer");
		 document.getElementById('answer').style.borderColor = "red";
		 return false;
		 }
	 
}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1" align="center">
<h1>Forgot password</h1>
</div>
<div align="center">
<div class="forms-data">
<form name="emppwd" action="/emp/getpwd" method="post" onsubmit="return formvalidation()">
<table>
<tr>
<td>Enter Userid:</td>
<td>
<input type="text" name="userId" id="userId" class="form-control" onfocus="validateuid()">
</td>
</tr>
<tr>
<td>Select question:</td>
<td>
<select name="question" style="margin-bottom:2px;margin-top:12px;padding:4px">
<option value="what is your pet name?">what is your pet name?</option>
<option value="what is your nick name?">what is your nick name?</option>
<option value="what is your school name?">what is your school name?</option>
</select>
</td>
</tr>
<tr>
<td>Enter answer:</td>
<td><input type="text" name="answer" id="answer" class="form-control" onfocus="validateans()">
<br>
<span id="message">${message}</span>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="submit" class="formsubmitbutton"> 
</td>
</tr>
</table>
</form>
For Login?<a href="/emp/" style="color:white;">Login</a>
</div>
</div>
<script type="text/javascript">
function validateuid(){
	 document.getElementById('userId').style.borderColor = "grey";
}
function validateans(){
	 document.getElementById('answer').style.borderColor = "grey";
}
</script>
</body>
</html>