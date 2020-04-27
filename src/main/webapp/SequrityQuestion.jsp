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
<div align="center">
<div class="forms-data">
<form:form action="#" method="post" modelAttribute="secure">
<table>
<tr>
<td>secret question<br>for password recovery: <b style="color: red"> * </b></td>
<td>
<form:select path="">
<form:option value="what is your primary school name">what is your primary school name</form:option>
<form:option value="what is your pet name">what is your primary school name</form:option>
<form:option value="what is your favourite color">what is your primary school name</form:option>
</form:select>
</td>
</tr>
<tr>
<td>secret Answer: <b style="color: red"> * </b></td>
<td>
<form:input path="a" class="form-control"/>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="next" class="formsubmitbutton" />
</tr>
</table>
</form:form>
</div>
</div>
</body>
</html>