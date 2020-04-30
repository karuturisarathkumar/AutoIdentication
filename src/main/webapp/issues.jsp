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

<form:form action="issue" modelAttribute="logissue" method="post">
CardNumber:<form:input path="cardNumber"/><br>
Issues &nbsp<form:input path="issues"/><br>
Description:<form:input path="description"/><br>
 <input type="submit" value="send">
</form:form>

</body>

</html>