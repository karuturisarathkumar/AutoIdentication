<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Admin Registration</title>
<link rel="stylesheet" type="text/css" href="/AdminStyle.css">
<script type="text/javascript">

function Adminvalidation(){
 var firstname = document.getElementById("Fname");
 var lastname = document.getElementById("Lname");
 var age = document.getElementById("age");
 var gender = document.getElementById("gender");
 var mobile = document.getElementById("contactNumber");
 var city = document.getElementById("city");
 var state = document.getElementById("state");
 var userid = document.getElementById("userId");
 var password = document.getElementById("password");
 var paRegex = new RegExp("/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/");
 var usrRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");

 if(firstname =="" && lastname==""&& age ==""&& mobile==""&& city==""&&state==""&&userid==""&&password==""){

	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('Fname').style.borderColor = "red";
	 document.getElementById('Lname').style.borderColor = "red";
	 document.getElementById('age').style.borderColor = "red";
	 document.getElementById('contactNumber').style.borderColor = "red";
	 document.getElementById('city').style.borderColor = "red";
	 document.getElementById('state').style.borderColor = "red";
	 document.getElementById('userId').style.borderColor = "red";
	 document.getElementById('password').style.borderColor = "red";	 
	 }
 if(firstname==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('Fname').style.borderColor = "red";
	 }
 if(lastname ==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('Lname').style.borderColor = "red";
	 }
 if(age ==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('age').style.borderColor = "red";
	 
	 }
 if(mobile==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('contactNumber').style.borderColor = "red";
	 }
 if(city==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('city').style.borderColor = "red";
	 }
 if(state==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('state').style.borderColor = "red";
	 }
 if(userid==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('userId').style.borderColor = "red";
	 
	 }
 if(password ==""){
	 alert("Please update the highlighted mandatory field(s).");
	 document.getElementById('password').style.borderColor = "red";
	 }

 if(!paRegex.test(password)){
	 alert("password must contain only letters, numbers and underscores!");
	 }
if(!usrRegex.test(userid)){
	alert("userid must contain only letters and numbers");
}
 
}
</script>
</head>
<body>
<div class="header1">
<h1>Admin Registration</h1>
</div>
<div align="center">
<div class="forms-data">
<form:form>
<table>
<tr>
<td>FirstName:</td>
<td>
<form:input path="Firstname" id="Fname" class="form-control"/>
</td>
</tr>
<tr>
<td>LastName:</td>
<td>
<form:input path="Lastname" id="Lname" class="form-control"/>
</td>
</tr>
<tr>
<td>Age:</td>
<form:input path="Age" id="age" class="form-control"/>
</tr>
<tr>
<td>Gender:</td>
<td>
<form:radiobutton path="Male" value="Male" id="gender" class="form-control"/>
</td>
<td>
<form:radiobutton path="Female" value="Female" id="gender"/>
</td>
</tr>
<tr>
<td>Contact Number:</td>
<td>
<form:input path="ContactNumber" id="contactNumber" class="form-control"/>
</td>
</tr>
<tr>
<td>City:</td>
<td>
<form:input path="City" id="city" class="form-control"/>
</td>
</tr>
<tr>
<td>State:</td>
<td>
<form:input path="State" id="state" class="form-control"/>
</td>
</tr>
<tr>
<td>UserId:</td>
<td>
<form:input path="UserId" id="userId" class="form-control"/>
</td>
</tr>
<tr>
<td>Password</td>
<form:password path="Password" id="password" class="form-control"/>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton"/></td>
</tr>
</table>
</form:form>
Already Admin?<a href="" style="color:yellow;">Login</a>
</div>
<a href="/">Home</a>
</div>
</body>
</html>