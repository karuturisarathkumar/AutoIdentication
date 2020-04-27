<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
function adminforgotuserid(){
	var phone = document.adminforgotusrid.contactNumber.value;	
	var Answer = document.adminforgotusrid.answer.value;
	if(phone==""){
		alert("enter phonenumber");
		document.getElementById('cnumber').style.borderColor = "red";
		return false;		
		}
	if(Answer==""){
		alert("enter answer");
		document.getElementById('ans').style.borderColor = "red";
		return false;
		}
}
</script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1" align="center">
<h1>Forgot UserId</h1>
<div align="center">
<div class="forms-data" style="margin-top:10px;">
  <form name="adminforgotusrid" action="/admin/getUserId" method="post" onsubmit="return adminforgotuserid()">  
     <table>     
     <tr> 
     <td>Enter Mobile </td>
     <td><input type="text" name="contactNumber" id="cnumber" class="form-control" onfocus="validatephn()">     
     </td>     
     </tr>
     <tr>
     <td>Select question</td>
     <td>
     <select name="question" style="margin-bottom:2px;margin-top:12px;padding:4px">
     <option value="what is your pet name?">what is your pet name?</option>
     <option value="what is your nick name?">what is your nick name?</option>
     <option value="what is your school name?">what is your school name?</option>
     </select>
     </td>
     </tr>
     <tr>
     <td>Enter answer</td>
     <td><input type="text" name="answer" id="ans" class="form-control" onfocus="validateanswer()">
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
<a href="/admin/" style="color:white;">Login</a>
</div>
</div>
</div>
<script type="text/javascript">
function validatephn(){
	document.getElementById('cnumber').style.borderColor = "grey";
}
function validateanswer(){
	document.getElementById('ans').style.borderColor = "grey";
}
</script>
</body>
</html>