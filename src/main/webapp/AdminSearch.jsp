<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div align="center" style="padding-top: 15px; ">
<form action="#" method="post">
<input type="text" placeholder="Account Number" style="padding: 10px;height: 15px;width: 200px;border-radius: 10px;border-color:green" name="num">
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
     <td><button><a href="/admin/setvalidate?id=${cust.accountNumber}" style="color: red;">Validate</a></button>
           <button><a href="/admin/setautowaver?id=${cust.accountNumber}" style="color: red;">AutoWaver</a></button>
           <button><a href="/admin/setdefaulter?id=${cust.accountNumber}" style="color: red;">defaulter</a></button>
           </td>
        </tr>   
</table>
</div>

</body>
</html>