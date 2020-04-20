<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script>
function validation()
var firstname=document.forms["register"]["firstName"].value;
var lastname=document.forms["register"]["lastName"].value;
var age=document.forms["register"]["age"].value;
var gender=document.forms["register"]["gender"].value;
var number=document.forms["register"]["contactNumber"].value;
var city=document.forms["register"]["city"].value;
var state=document.forms["register"]["state"].value;
var userid=document.forms["register"]["userId"].value;
var password=document.forms["register"]["password"].value;
if(firstname=" "|| firstname==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(lastname=" "|| lastname==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(age=" "|| age==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(gender=" "|| gender==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(number=" "|| number==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(city=" "|| city==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(state=" "|| state==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(userid=" "|| userid==null)
{
alert("please update the highlighted mandatory fields");
return false;
}
else if(password=" "|| password==null)
{
alert("please update the highlighted mandatory fields");
return false;
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
<form:form name="register" action="/emp/verifyregister" method="post" modelAttribute="bankemployee" onsubmit="validation()" style="margin-top:50px;margin-left:30px;" >
<table>
<tr>
<td>User Id</td>
<td>
<form:input path="userId" class="form-control"/>
<br>
<form:errors path="userId" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>First Name</td>
<td>
<form:input path="firstName" class="form-control"/>
<br>
<form:errors path="firstName" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Last Name</td>
<td>
<form:input path="lastName" class="form-control"/>
<br>
<form:errors path="lastName" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Age</td>
<td>
<form:input path="age" class="form-control"/>
<br>
<form:errors path="age" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Gender</td>
<td>
<form:input path="gender" class="form-control"/>
<br>
<form:errors path="gender" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>Contact Number</td>
<td>
<form:input path="contactNumber" class="form-control"/>
<br>
<form:errors path="contactNumber" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>City</td>
<td>
<form:input path="city" class="form-control"/>
<br>
<form:errors path="city" cssClass="errors"></form:errors>
<br>
</td>
</tr>
<tr>
<td>State</td>
<td>
<form:input path="state" class="form-control"/>
<br>
<form:errors path="state" cssClass="errors"></form:errors>
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
<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton" />
</tr>
</table>
</form:form>
Existing Bank Employee<a href="/emp/" style="color:Navy;">Login</a>
</div>
<a href="/" style="color:Navy;">Home Page</a>
</div>
</body>
</html>