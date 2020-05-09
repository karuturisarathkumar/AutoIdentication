<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/menubar.css">
<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
</head>
<body>
<%
String user =(String) session.getAttribute("userid");
if(user==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="maindiv" >
<span style="font-size:30px;cursor:pointer;color:white; right: 0;" onclick="openNav()" >&#9776;</span>
<h1 style="text-align: center;color: white;font-size:20px;margin-top:-23px;"> Welcome <span style="color:white;"><%=user.toUpperCase() %></span></h1>
</div>

<div id="mySidenav" class="sidenav">
<a href="javascript:void(0)" class="closebtn" style="margin-top:-54px;" onclick="closeNav()">&times;</a>  
  <ul>
 <!--  <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i>View Profile</a></li>
  <li><a href="#"><i class="fa fa-key" aria-hidden="true"></i>change password</a></li> -->
  <li><a href="/admin/homeadmin"><i class="fa fa-home"></i>Home</a></li>
  <li class="dropdown"><a href="#"><i class="fa fa-users" aria-hidden="true"></i>Defaulter</a>
  <div class="dropdown-content">
    <a href="/admin/autocustlist">AutoDefaulters</a>
    <a href="/admin/manualcustlist">ManualDefaulters</a>
    <a href="/admin/list">Customers</a>
    <a href="/admin/sixmonthlist">six months</a>
  </div>
  </li>
  <li><a href="/admin/getemplist"><i class="fa fa-user" aria-hidden="true"></i>New Employee</a></li>
  <li class="dropdown"><a href="#"><i class="fa fa-credit-card" aria-hidden="true"></i>Cards</a>
  <div class="dropdown-content">
    <a href="/admin/ativates"><i class="fa fa-universal-access"></i>Reactivation</a>
    <a href="/admin/deactivates"><i class="fa fa-ban"></i>deactivation</a>    
  </div>
  </li>
  <li class="dropdown"><a href="#"><i class="fa fa-flag"></i>Report</a>
  <div class="dropdown-content">
  <a href="/admin/genRep">Over all report</a>
  <a href="/admin/autocustlist">no.of AutoDefaulter</a>
  <a href="/admin/manualcustlist">no.of ManualDefaulter</a>
  <a href="/admin/DefList">no.of Defalters</a>
  <a href="/admin/activationList">no.of Re_activations</a>
  </div>  
  </li>
  <li class="dropdown"><a href="#"><i class="fa fa-address-card-o" aria-hidden="true"></i>Contact Us</a>
  <div class="dropdown-content">
  <a href="#">phone:+(91)-8688292729</a>
  <a href="#">Mail id:-autoidentification@gmail.com</a>
  </div>
   </li>
  <li><a href="/"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
  </ul>  
</div>


<div align="center" style="padding-top: 60px;">
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
<div align="center" style="margin-top: 10px;">
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
    <td>${customer.status}</td>       
    
  <td>  
   <c:if test="${customer.status == 'validate'}">
      <a href="/admin/setautowaver?id=${customer.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:blue;border-radius:5px;">AutoWaver</button></a>
   
    <a href="/admin/setdefaulter?id=${customer.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:red;border-radius:5px;">defaulter</button></a>
     </c:if>
     
     
     <c:if test="${customer.status == 'autowaver'}">
     
    <a href="/admin/setvalidate?id=${customer.accountNumber}" enabled="enabled" style="color: red;"><button style="background-color:green;border-radius:5px;">Validate</button></a>
    <a href="/admin/setdefaulter?id=${customer.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:red;border-radius:5px;">defaulter</button></a>
     </c:if>
     
      <c:if test="${customer.status == 'defaulter'}">
     
       <a href="/admin/setautowaver?id=${customer.accountNumber}" style="color: red;" enabled="enabled"><button style="background-color:blue;border-radius:5px;">AutoWaver</button></a>
    <a href="/admin/setvalidate?id=${customer.accountNumber}" enabled="enabled" style="color: red;"><button style="background-color:green;border-radius:5px;">Validate</button></a>
   
     </c:if> 
     </td>
    
           </tr>
</c:forEach>

<c:forEach items="${custList}" var="customer">
<jsp:useBean id="date" class="java.util.Date"/>

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
</body>
</html>