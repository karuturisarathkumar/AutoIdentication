<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="padding-top: 180px;">
<form action="/emp/verPay">

<input type="text"  placeholder="Enter Amount" name="amount" style="height: 30px;"><input type="submit" value="pay">
</form>
</div>

<%
RequestDispatcher rd = request.getRequestDispatcher("emphome.jsp");
rd.include(request, response);
%>
</body>
</html>