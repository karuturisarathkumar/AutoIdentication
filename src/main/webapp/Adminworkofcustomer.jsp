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
<table border="2"  style="background-color: black;">
 <tr>
<th>AccountNumber</th>
<th>Name</th>
<th>Amount</th>
<th>tenure</th>
<th>email</th>
<th>mobile</th>
<th>Last paid date</th>
<th>dues</th>
<th>money paid</th>
<th>fine</th>
<th>accuralStatus</th>
<th>borrower rating</th>
<th>status</th>
</tr>
<c:forEach items="${customerList}" var="customer">

 <tr>
      <td>${customer.accountNumber}</td>
       <td>${customer.customerName}</td>
        <td>${customer.borrowedAmount}</td>
         <td>${customer.tenure}</td>
          <td>${customer.email}</td>
           <td>${customer.mobile}</td>
           <td>${customer.lastPaid}</td>
           <td>${customer.dues}</td>
           <td>${customer.moneyPaid}</td>
           <td>${customer.fine}</td>
           <td>${customer.accuralStatus}</td>
           <td>${customer.borrowerRating}</td>
           <td>${customer.status}<button><a href="#" style="color: red;">Validate</a></button><button><a href="#" style="color: red;">AutoWaver</a></button></td>
           
</c:forEach>

<c:forEach items="${custList}" var="customer">

 <tr>
      <td>${customer.accountNumber}</td>
       <td>${customer.customerName}</td>
        <td>${customer.borrowedAmount}</td>
         <td>${customer.tenure}</td>
          <td>${customer.email}</td>
           <td>${customer.mobile}</td>
           <td>${customer.lastPaid}</td>
           <td>${customer.dues}</td>
           <td>${customer.accuralStatus}</td>
           <td>${customer.borrowerRating}</td>
           <td>${customer.status}</td>
           <td><button><a href="#" style="color: red;">send alert</a></button></td>
</c:forEach>
</table>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("Adminhome.jsp");
rd.include(request, response);

%>
</body>
</html>