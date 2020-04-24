<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div align="center">
<table border="2">
<c:forEach items="${custlist}" var="customer">
<tr>
     <td><a href="/emp/duelist"  style="color: yellow;">${customer.customerName}-->Dues:${customer.dues}</a></td>
    </tr>
</c:forEach>
</table>
</div>
${message}
<div align="center">
<table border="2">
<c:forEach items="${duelessthan3}" var="due">
<tr>
     <td><a   style="color: yellow;">${due.customerName}</a></td>
     </tr>
</c:forEach>
</table>
</div>
<div align="center">
<table border="2">
<c:forEach items="${duelessthan12}" var="d">
<tr>
     <td><a style="color: yellow;">${d.customerName}</a></td>
     </tr>
</c:forEach>
</table>
</div>
<div align="center">
<table border="2">
<c:forEach items="${duelessthan6}" var="du">
<tr>
     <td><a style="color: yellow;">${du.customerName}</a></td>
     </tr>
</c:forEach>
</table>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("emphome.jsp");
rd.include(request, response);

%>
</body>
</html>