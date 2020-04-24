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
<div>

<form:form action="/emp/empforget" method="post" modelAttribute="passwordsecure">
<table>
<tr>
<td>userid <b style="color: red"> * </b></td>
<td>
<form:input path="userId"/>
</td>
</tr>
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

<tr>
<td colspan="2" align="center"><input type="submit" value="verify" class="formsubmitbutton" />
</tr>
</table>

</form:form>


</div>
</body>
</html>