<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div align="center" style="padding-top: 60px; ">
<form action="#" method="post">
<select name="number" style="height: 40px" >
<option value=" accountNumber">account number</option>
<option value="dues">dues</option>
<option value="moneyPaid">amount paid</option>
</select>
<input type="submit" value="sort" style="height: 25px;width: 50px;">
</form>

</div>
<div>

</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("Adminworkofcustomer.jsp");
rd.include(request, response);

%>
</body>
</html>