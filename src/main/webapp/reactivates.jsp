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
<div align="center" style="padding-top: 100px; ">
<table border="2" style="background-color: black">
<tr>
<th>card number</th>
<th>account number</th>
<th>name</th>
<th>Date</th>
<th>Reason</th>
<th>status</th>
</tr>
<c:forEach items="${card}" var="cus">
<tr>
  <td>${cus.cardNumber}</td>  
  <td>${cus.accountNumber}</td> 
  <td>${cus.customerName}</td>  
  <td>${cus.expDate}</td> 
  <td>${cus.reActivationReason}</td> 
  <td>${cus.cardStatus}<a href="/admin//verifycard?id=${cus.accountNumber}"><button>Activate</button></a><a href="/admin/decCard?id=${cus.accountNumber}"><button>deactivate</button></a></td> 
  </tr>
  </c:forEach>
</table>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("Adminhome.jsp");
rd.include(request, response);

%>
</body>
</html>