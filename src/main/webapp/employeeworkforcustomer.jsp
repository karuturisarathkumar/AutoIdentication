<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body >
<div align="center" style="background-color:burlywood;height:600px;margin-top: -17px;">
<h1 align="center" style="font-family:monospace;color:red;font-size:25px;">Defaulters List</h1>
<table border="2">
<c:forEach items="${custlist}" var="customer">
<tr>
     <td><a href="/emp/details?id=${customer.accountNumber}"  style="color: black;">${customer.accountNumber}</a></td>

     <%-- <td><a href="/emp/duelist"  style="color: yellow;">${customer.customerName}-->Dues:${customer.dues}</a></td> --%>
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