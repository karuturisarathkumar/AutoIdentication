<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function disButton()
{
	var s="${card.cardStatus}";
	if(s=="Re-active")
		{
	document. getElementById("btn1"). disabled = true;
	document. getElementById("btn2"). disabled = true;
		}
	if(s=="deactive")
	{
document. getElementById("btn2"). disabled = true;
	}
	if(s=="active")
	{
document. getElementById("btn1"). disabled = true;
	}
}

</script>
</head>
<body>



<div align="center" style="padding-top:45px; ">
<h1 style="font-family: initial;color: red;font-size: 25px;">Card details</h1>
<form  action="/emp/blockcard" method="post" >
<table border="2">
<tr>
  <td>card number</td> 
  <td><c:out value="${card.cardNumber}"></c:out></td> 
 </tr>
 <tr>
  <td>account number</td> 
  <td ><c:out value="${card.accountNumber}"></c:out></td> 
 </tr>
  <tr>
  <td>name</td> 
  <td><c:out value="${card.customerName}"></c:out></td> 
 </tr>
  <tr>
  <td>Date</td> 
  <td><c:out value="${card.expDate}"></c:out></td> 
 </tr>
 
  <tr>
  <td>Reason</td> 
  <td><input type="text"  name="reason"></td>
 </tr>
  <tr>
  <td>card status</td>  
  <td><c:out value="${card.cardStatus}"></c:out></td> 
 </tr> 

</table>

 <input type="submit" value="deactivate" id="btn1" style="background-color:red;border-radius:5px;"/> 
 


</form>

</div>

<%

RequestDispatcher rd = request.getRequestDispatcher("employeehome.jsp");
rd.include(request, response);

%>
</body>
</html>