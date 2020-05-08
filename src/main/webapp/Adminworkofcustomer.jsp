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

<div align="center" style="padding-top: 20px; ">
<form action="/admin/getAccount" method="post">
<input type="text" placeholder="Account Number" style="padding: 10px;height: 15px;width: 200px;border-radius: 10px;border-color:green" name="num">
<input type="submit" value="search" style="height:20px;width: 50px;border-radius: 10px;background-color: blue;">
</form>
</div>

<div align="center" style="padding-top: 60px; ">
<form action="/admin/sort" method="post">
<select name="number" style="height: 40px" >
<option value="accountNumber">account number</option>
<option value="dues">dues</option>
<option value="moneyPaid">amount paid</option>
</select>
<select name="order" style="height: 40px" >
<option value="ass">Asscending</option>
<option value="des">Descending</option>
</select>
<input type="submit" value="sort" style="height: 25px;width: 50px;">
</form>
</div>
<div align="center">
<table border="2" style="margin-top:25px;">
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
    <td>${customer.status}</td>       <td><button><a href="/admin/setvalidate?id=${customer.accountNumber}" style="color: red;">Validate</a></button>
           <button><a href="/admin/setautowaver?id=${customer.accountNumber}" style="color: red;">AutoWaver</a></button>
           <button><a href="/admin/setdefaulter?id=${customer.accountNumber}" style="color: red;">defaulter</a></button>
           </td>
           </tr>
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
           <td>${customer.moneyPaid}</td>
            <td>${customer.fine}</td>
           <td>${customer.accuralStatus}</td>
           <td>${customer.borrowerRating}</td>
           <td>${customer.status}</td>
           <td><button><a href="/admin/sendalert?id=${customer.accountNumber}" style="color: red;">send alert</a></button></td>
           </tr>
</c:forEach>


</table>
</div>


<%

RequestDispatcher rd = request.getRequestDispatcher("sampleadminhome.jsp");
rd.include(request, response);

%>
</body>
</html>