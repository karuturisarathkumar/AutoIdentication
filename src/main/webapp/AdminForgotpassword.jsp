<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function eformvalidation()
{
	 var userid = document.pf1.userId.value;
	 var answer = document.pf1.answer.value;	 
	 if(userid ==""|| userid==null){
		 alert("please enter userid");
		 document.getElementById('uid').style.borderColor = "red";
		 return false;
		 }
	 if(answer ==""|| answer==null){
		 alert("please enter answer");
		 document.getElementById('Ans').style.borderColor = "red";
		 return false;
		 }
}
</script>
<meta charset="ISO-8859-1">
<title>Admin - Forgot password</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1" align="center">
<h1>Forgot password</h1>
</div>
<div align="center">
<div class="forms-data">
<form name="pf1" action="/admin/getpwd" method="post" onsubmit="return eformvalidation()">
<table>
<tr>
<td>Enter Userid:</td>
<td>
<input type="text" name="userId" id="uid" class="form-control" onfocus="validateuserid()">
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
<td><input type="text" name="answer" id="Ans" class="form-control" onfocus="validateanswer()">
<br>
<span>${message}</span>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="submit" class="formsubmitbutton"> 
</td>
</tr>
</table>
</form>
For Login?<a href="/admin/" style="color:white;">Login</a>
</div>
</div>
<script type="text/javascript">
function validateuserid(){
	document.getElementById('uid').style.borderColor = "grey";	
}
function validateanswer(){
	document.getElementById('Ans').style.borderColor = "grey";
}
</script>
</body>
</html>