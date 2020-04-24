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
<table border="2" style="background-color: red">
<c:forEach items="${custlist}" var="customer">
<tr>
     <td><a href="/emp/details?id=${customer.accountNumber}"  style="color: yellow;">${customer.customerName}</a></td>
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