<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="padding-top: 80px; ">
<form action="/emp/getCard" method="post">
<input type="text" placeholder="search" style="padding: 20px;height: 15px;width: 250px;" name="number">
<input type="submit" value="search" style="height: 18px;width: 50px;">
</form>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("emphome.jsp");
rd.include(request, response);

%>

</body>
</html>