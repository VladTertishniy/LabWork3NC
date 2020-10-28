<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Suppliers</title>
</head>
    <style>
    .text {
    text-align:  center;
    }
    </style>
    <body>
    <img height="50%" width="100%" src="/files/top.png"/>
    <div class="text">
    <font size="10" color="black" face="algerian">
<p>Suppliers</p>

<div>All suppliers:</div>

<table border="2" width="100%" cellpadding="2">
<tr>
<th>User id</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Phone number</th>
<th>Email</th>
<th>Organization</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="suppliersList" items="${suppliersList}">
    <tr>
    <td>${suppliersList.user.user_id}</td>
    <td>${suppliersList.firstname}</td>
    <td>${suppliersList.lastname}</td>
    <td>${suppliersList.phoneNumber}</td>
    <td>${suppliersList.email}</td>
    <td>${suppliersList.organization}</td>
    <td><a href = "suppliers/editSupplier/${suppliersList.user.user_id}">Edit</a></td>
    <td><a href = "suppliers/deleteSupplier/${suppliersList.user.user_id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="suppliers/addSupplier">Add supplier</a></br>
<a href="index.jsp" >Back to main page</a>
    </font>
    </div>
</body>
</html>