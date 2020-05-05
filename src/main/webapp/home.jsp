<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Auto Identification System</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class ="menubar" align="center">
<h1 style="size: 20px; color: white;"><a href="/">Auto-Identification</a></h1>
<ul>
<li><a href="/admin/"><i class="fa fa-user-o"></i>AIP Admin</a></li>
<li><a href="/emp/"><i class="fa fa-user"></i>Bank Employee</a></li>
</ul>

</div>
<div class="topright">
<a href="/admin/issues"><i class="fa fa-wrench" aria-hidden="true" ></i>Issues</a>
</div>

<div align="center" style="padding-top: 80px; ">
<h1 style="color: green;font-size: 40px;">${message}</h1>
</div>


</body>
</html>