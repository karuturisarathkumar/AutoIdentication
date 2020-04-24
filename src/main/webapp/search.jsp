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
<div align="center" style="padding-top: 80px; ">
<form action="/emp/getCard" method="post">
<input type="text" placeholder="search" style="padding: 20px;height: 15px;width: 250px;" name="number">
<input type="submit" value="search" style="height: 18px;width: 50px;">
</form>
</div>

<div align="center" style="padding-top: 100px; ">
<table border="2" style="background-color: red">
<form>
<tr>
  <td>card number</td> 
  <td style="background-color: blue;"><c:out value="${card.cardNumber}"></c:out></td> 
 </tr>
 <tr>
  <td>account number</td> 
  <td style="background-color: blue;"><c:out value="${card.accountNumber}"></c:out></td> 
 </tr>
  <tr>
  <td>name</td> 
  <td style="background-color: blue;"><c:out value="${card.customerName}"></c:out></td> 
 </tr>
  <tr>
  <td>Date</td> 
  <td style="background-color: blue;"><c:out value="${card.expDate}"></c:out></td> 
 </tr>
 
  <tr>
  <td>Reason</td> 
  <td><input type="text" name="reason"></td>
 </tr>
  <tr>
  <td>card status</td>  
  <td style="background-color: blue;"><c:out value="${card.cardStatus}"></c:out></td> 
 </tr>
 <tr style="padding-right: 50px;">
   <td></td>
 </tr>
</table>

 <input type="submit" value="reactivate"/>
</form>
</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("emphome.jsp");
rd.include(request, response);

%>
</body>
</html>