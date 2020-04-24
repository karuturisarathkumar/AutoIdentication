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
<div align="center" style="padding-top: 150px">
<table border="2" style="background-color: red">
<tr>
  <td>Account number</td>  
  <td style="background-color: blue;"><c:out value="${customer.accountNumber}"></c:out></td> 
 </tr>
 <tr>
  <td>Name</td>  
  <td style="background-color: blue;"><c:out value="${customer.customerName}"></c:out></td> 
 </tr>
 <tr>
  <td>Amount</td>  
  <td style="background-color: blue;"><c:out value="${customer.borrowedAmount}"></c:out></td> 
 </tr>
 <tr>
  <td>tenure</td>  
  <td style="background-color: blue;"><c:out value="${customer.tenure}"></c:out></td> 
 </tr>
 <tr>
  <td>email</td>  
  <td style="background-color: blue;"><c:out value="${customer.email}"></c:out></td> 
 </tr>
  <tr>
  <td>mobile</td>  
  <td style="background-color: blue;"><c:out value="${customer.mobile}"></c:out></td> 
 </tr>
  <tr>
  <td>lastpaid on</td>  
  <td style="background-color: blue;"><c:out value="${customer.lastPaid}"></c:out></td> 
 </tr>
 <tr>
  <td>Dues</td>  
  <td style="background-color: blue;"><c:out value="${customer.dues}"></c:out></td> 
 </tr>
  <tr>
  <td>card number</td>  
  <td style="background-color: blue;"><c:out value="${card.cardNumber}"></c:out></td> 
 </tr>
  <tr>
  <td>card status</td>  
  <td style="background-color: blue;"><c:out value="${card.cardStatus}"></c:out></td> 
  <td><button><a herf="#"></a>Re-activate</button></td>
   <td><button><a herf="#"></a>Deactivate</button></td>
 </tr>
</table>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("emphome.jsp");
rd.include(request, response);

%>
</body>
</html>