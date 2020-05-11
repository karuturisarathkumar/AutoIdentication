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
<input type="text" placeholder="search" style="padding: 20px;height: 15px;width: 250px;border-color:green" name="number" required>
<input type="submit" value="search" style="height:40px;width: 80px;border-radius: 10px;background-color: red;">
</form>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("employeehome.jsp");
rd.include(request, response);

%>

</body>
</html>