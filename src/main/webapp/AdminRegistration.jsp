<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Admin Registration</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script type="text/javascript">

function Adminvalidation(){
	var firstname=document.frm.firstName.value;
	var lastname=document.frm.lastName.value;
	var age=document.frm.age.value;
	var gender=document.frm.gender.value;
	var number=document.frm.contactNumber.value;
	var city=document.frm.city.value;
	var state=document.frm.state.value;
	var userid=document.frm.userId.value;
	var password=document.frm.password.value;
	var answer = document.frm.answer.value;
	var confirmpassword = document.frm.confirmationpassword.value;	
	if(firstname==""|| firstname==null)
	{
	alert("please update the highlighted mandatory fields");
	document.getElementById('Fname').style.borderColor = "red";
	return false;
	}
	if(lastname==""|| lastname==null)
	{
	  alert("Please update the highlighted mandatory field(s).");
	  document.getElementById('Lname').style.borderColor = "red";
	  return false;
	}
	if(age==0 || age==null || age =="")
	{
		alert("Please update the highlighted mandatory field(s).");
		 document.getElementById('Age').style.borderColor = "red";
		 return false;
	}
    if(gender==""|| gender==null)
	{
	alert("please select gender");	
	return false;
	} 
	if(number==""|| number==null)
	{
		 alert("Please update the highlighted mandatory field(s).");
		 document.getElementById('ContactNumber').style.borderColor = "red";
		 return false;
	}
	if(city==""|| city==null)
	{
		 alert("Please update the highlighted mandatory field(s).");
		 document.getElementById('City').style.borderColor = "red";
		 return false;
	}
	if(state==""|| state==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('State').style.borderColor = "red";
		return false;
	}
	if(userid==""|| userid==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('UserId').style.borderColor = "red";
		return false;
		 
	}
	if(password==""|| password==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('Password').style.borderColor = "red";
		return false;
	}
	if(answer==""|| answer==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('Answer').style.borderColor = "red";
		return false;
	}
	if(confirmpassword==""|| confirmpassword==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('cPassword').style.borderColor = "red";
		return false;
	}
	if(password!=confirmpassword){
		alert("The password and confirm password should be same");
		return false;
		}	
	
}
</script>
</head>
<body>
<div class="header1" align="center">
<h1>Admin Registration</h1>
</div>
<div align="center">
<div class="forms-data">
<form:form name="frm" action="/admin/adminregvalidate" method="post" modelAttribute="admin"  style="margin-top:50px;margin-left:30px;" onsubmit="return Adminvalidation()">
<table>
<tr>
<td>User Id <b style="color: red"> * </b> </td>
<td>
<form:input path="userId" id="UserId" class="form-control" onfocus="validateuserid()"/>
<form:errors path="userId" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>First Name  <b style="color: red"> * </b></td>
<td>
<form:input path="firstName" id="Fname" class="form-control" onfocus="validateFirstname()"/>
<form:errors path="firstName" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>Last Name  <b style="color: red"> * </b></td>
<td>
<form:input path="lastName"  id="Lname" class="form-control" onfocus="validateLastname()"/>
<form:errors path="lastName" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>Age  <b style="color: red"> * </b></td>
<td>
<form:input path="age" id="Age" class="form-control" onfocus="validateage()"/>
<form:errors path="age" cssClass="errors"></form:errors>
</td>
</tr>
<%-- <tr>
<td>Gender  <b style="color: red"> * </b></td>
<td>
<form:input path="gender" id="Gender" class="form-control" onfocus="validategender()"/>
<form:errors path="gender" id="" cssClass="errors"></form:errors>
</td>
</tr> --%>
<tr>
 <td>Gender  <b style="color: red"> * </b></td>
 <td>
 <form:radiobutton path="gender" value="Male" label="Male" cssStyle="margin-left:-65px;"/>
 <form:radiobutton path="gender" value="Female" label="Female"/>
 </td> 
 </tr>
<tr>
<td>Contact Number  <b style="color: red"> * </b> </td>
<td>
<form:input path="contactNumber" id="ContactNumber" class="form-control" onfocus="validatemobile()"/>
<form:errors path="contactNumber" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>City  <b style="color: red"> * </b></td>
<td>
<form:input path="city" id="City" class="form-control" onfocus="validatecity()"/>
<form:errors path="city" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>State  <b style="color: red"> * </b></td>
<td>
<form:input path="state" id="State"  class="form-control" onfocus="validatestate()"/>
<form:errors path="state" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>Password  <b style="color: red"> * </b></td>
<td>
<form:password path="password" id="Password" class="form-control" onfocus="validatepassword()"/>
<form:errors path="password" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>Confirmation Paasword  <b style="color: red"> * </b></td>
<td>
<form:password path="confirmationpassword" id="cPassword" class="form-control" onfocus="validatecpassword()"/>
<form:errors path="confirmationpassword" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<form:form action="#" method="post" modelAttribute="securityque">
<tr>
<td>Questions <b style="color: red"> * </b></td>
<td>
<form:select path="question" style="margin-bottom:2px;margin-top:12px;padding:4px">
<form:option value="what is your pet name?">what is your pet name?</form:option>
<form:option value="what is your nick name?">what is your nick name?</form:option>
<form:option value="what is your school name?">what is your school name?</form:option>
</form:select>
</td>
</tr>
<tr>
<td>Answer <b style="color: red"> * </b></td>
<td>
<form:input path="answer" id="Answer" class="form-control" onfocus="validateanswer()"/>
</td>
</tr>
</form:form>
<tr>
<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton"/></td>
</tr>
</table>
</form:form>
Already Admin?<a href="/admin/" style="color:yellow;">Login</a>
</div>
<a href="/">Home</a>
</div>
<script type="text/javascript">
function validateFirstname(){
	document.getElementById('Fname').style.borderColor = "grey";
}
function validateLastname(){
	document.getElementById('Lname').style.borderColor = "grey";
}
function validateage(){
	document.getElementById('Age').style.borderColor = "grey";
}
function validategender(){
	document.getElementById('Gender').style.borderColor = "grey";
}
function validatemobile(){
	document.getElementById('ContactNumber').style.borderColor = "grey";
}
function validatecity(){
	document.getElementById('City').style.borderColor = "grey";
}
function validatestate(){
	document.getElementById('State').style.borderColor = "grey";
}
function validateuserid(){
	document.getElementById('UserId').style.borderColor = "grey";
}
function validatepassword(){
	document.getElementById('Password').style.borderColor = "grey";
}
function validatecpassword(){
	document.getElementById('cPassword').style.borderColor = "grey";
}
function validateanswer(){
	document.getElementById('Answer').style.borderColor = "grey";
}
</script>
</body>
</html>