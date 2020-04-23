<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script>
function validation()
{
var firstname=document.forms["register"]["firstName"].value;
var lastname=document.forms["register"]["lastName"].value;
var age=document.forms["register"]["age"].value;
var gender=document.forms["register"]["gender"].value;
var number=document.forms["register"]["contactNumber"].value;
var city=document.forms["register"]["city"].value;
var state=document.forms["register"]["state"].value;
var userid=document.forms["register"]["userId"].value;
var password=document.forms["register"]["password"].value;
if(firstname==" "|| firstname==null)
{
alert("please update the highlighted mandatory fields");
document.getElementById('Fname').style.borderColor = "red";
return false;
}
else if(lastname==" "|| lastname==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(age==0 || age==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(gender==" "|| gender==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(number==" "|| number==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(city==" "|| city==null)
{
alert("please update the highlighted mandatory fields");
document.getElementById('empcity').style.borderColor = "red";
return false;
}
else if(state==" "|| state==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(userid==" "|| userid==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(password==" "|| password==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
}
</script>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1">
<h1>Bank Employee - Registration</h1>
</div>
<div align="center">
<div class="forms-data">
<form:form name="register" action="/emp/verifyregister" method="post" modelAttribute="bankemployee" onsubmit="return validation()" style="margin-top:50px;margin-left:30px;" >
<table>
<tr>
<td>User Id <b style="color: red"> * </b> </td>
<td>
<form:input path="userId" id="userId" class="form-control"/>
<br>
<form:errors path="userId" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>First Name  <b style="color: red"> * </b></td>
<td>
<form:input path="firstName" id="Fname" class="form-control"/>
<br>
<form:errors path="firstName" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Last Name  <b style="color: red"> * </b></td>
<td>
<form:input path="lastName"  id="lastName" class="form-control"/>
<br>
<form:errors path="lastName" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Age  <b style="color: red"> * </b></td>
<td>
<form:input path="age" id="age" class="form-control"/>
<br>
<form:errors path="age" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Gender  <b style="color: red"> * </b></td>
<td>
<form:input path="gender" id="gender" class="form-control"/>
<br>
<form:errors path="gender" id="" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Contact Number  <b style="color: red"> * </b> </td>
<td>
<form:input path="contactNumber" id="contactNumber" class="form-control"/>
<br>
<form:errors path="contactNumber" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>City  <b style="color: red"> * </b></td>
<td>
<form:input path="city" id="empcity" class="form-control"/>
<br>
<form:errors path="city" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>State  <b style="color: red"> * </b></td>
<td>
<form:input path="state" id="state"  class="form-control"/>
<br>
<form:errors path="state" cssClass="errors"></form:errors>
<br>
</td>
</tr>

<tr>
<td>Password  <b style="color: red"> * </b></td>
<td>
<form:password path="password" id="password" class="form-control"/>
<br>
<form:errors path="password" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<form:form action="#" method="post" modelAttribute="secure">
<tr>
<td>Questions <b style="color: red"> * </b></td>
<td>
<form:select path="question">
<form:option value="1">what is your pet name?</form:option>
<form:option value="2">what is your grandmother name?</form:option>
<form:option value="3">what is your school name?</form:option>
</form:select>
</td>
</tr>
<tr>
<td>Answer <b style="color: red"> * </b></td>
<td>
<form:input path="answer"/>
</td>
</tr>
</form:form>
<tr>
<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton" />
</tr>
</table>
</form:form>
Existing Bank Employee?<a href="/emp/" style="color:white;">Login</a>
</div>
<a href="/" style="color:black;">Home Page</a>
</div>
</body>
</html>