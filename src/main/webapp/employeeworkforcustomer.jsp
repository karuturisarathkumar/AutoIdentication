<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>


<div align="center">
<form action="/emp/getAccountNumber" method="post">
<input type="text" placeholder="Account Number" style="padding: 10px;height: 15px;width: 200px;border-radius: 10px;border-color:green" name="num" required>
<input type="submit" value="search" style="height:20px;width: 50px;border-radius: 10px;background-color: blue;">
</form>
</div>

<div align="center" style="background-color:burlywood;height:600px;margin-top: -10px;">
<h1 align="center" style="font-family:monospace;color:red;font-size:25px;">Defaulters List</h1>
<table border="2">
<c:forEach items="${custlist}" var="customer">
<tr>
     <td><a href="/emp/details?id=${customer.accountNumber}"  style="color: black;">${customer.accountNumber}</a></td>

  
    </tr>
</c:forEach>
</table>
</div>


<%
RequestDispatcher rd = request.getRequestDispatcher("employeehome.jsp");
rd.include(request, response);
%>
</body>
</html>