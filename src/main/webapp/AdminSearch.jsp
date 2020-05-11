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


<div align="center" style="padding-top: 60px; ">
<form action="#" method="post">
<input type="text" placeholder="Account Number" style="padding: 10px;height: 15px;width: 200px;border-radius: 10px;border-color:green" name="num" required>
<input type="submit" value="search" style="height:20px;width: 50px;border-radius: 10px;background-color: blue;">
</form>
</div>


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

<tr>
      <td>${cust.accountNumber}</td>
       <td>${cust.customerName}</td>
        <td>${cust.borrowedAmount}</td>
         <td>${cust.tenure}</td>
          <td>${cust.email}</td>
           <td>${cust.mobile}</td>
           <td>${cust.lastPaid}</td>
           <td>${cust.dues}</td>
           <td>${cust.moneyPaid}</td>
           <td>${cust.fine}</td>
           <td>${cust.accuralStatus}</td>
           <td>${cust.borrowerRating}</td>
    <td>${cust.status}</td>      
     
<td>  
   <c:if test="${cust.status == 'validate'}">
      <a href="/admin/setautowaver?id=${cust.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:blue;border-radius:5px;">AutoWaver</button></a>
   
    <a href="/admin/setdefaulter?id=${cust.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:red;border-radius:5px;">defaulter</button></a>
     </c:if>
     
     
     <c:if test="${cust.status == 'autowaver'}">
     
    <a href="/admin/setvalidate?id=${cust.accountNumber}" enabled="enabled" style="color: red;"><button style="background-color:green;border-radius:5px;">Validate</button></a>
    <a href="/admin/setdefaulter?id=${cust.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:red;border-radius:5px;">defaulter</button></a>
     </c:if>
     
      <c:if test="${cust.status == 'defaulter'}">
     
       <a href="/admin/setautowaver?id=${cust.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:blue;border-radius:5px;">AutoWaver</button></a>
    <a href="/admin/setvalidate?id=${cust.accountNumber}" enabled="enabled" style="color: red;"><button style="background-color:green;border-radius:5px;">Validate</button></a>
   
     </c:if> 
     </td>


        </tr>   
</table>
</div>

<% 
RequestDispatcher rd = request.getRequestDispatcher("sampleadminhome.jsp");
rd.include(request, response);

%>

</body>
</html>