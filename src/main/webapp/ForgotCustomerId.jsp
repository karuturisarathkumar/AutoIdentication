<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header1">
<h1>Forgot CustomerId</h1>
</div>
<div align="center">
<div class="forms-data">
<form:form action="" method="post" modelAttribute="">
<table>
<tr>
<td>Enter PhoneNumbber <b style="color: red"> * </b></td>
<td>
<form:input path="contactNumber" id="ContactNumber" class="form-control"/>
</td>
</tr>
<tr>
<td>select secret question<br> during registration: <b style="color: red"> * </b></td>
<td>
<select name="quesdropdown" id="qudp">
<option value="what is your primary school name">what is your primary school name</option>
    <option value="what is your pet name">what is your pet name</option>
    <option value="what is your favourite color">what is your favourite color</option>
</select>
</td>
</tr>
</table>
</form:form>
</div>
</div>
</body>
</html>