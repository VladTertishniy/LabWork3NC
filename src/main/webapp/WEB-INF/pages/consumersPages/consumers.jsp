<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Consumers</title>
</head>
<body>
<p>Consumers</p>

<div>All consumers:</div>

<table border="2" width="100%" cellpadding="2">
<tr>
<th>User id</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Phone number</th>
<th>Email</th>
<th>Counterparty type</th>
<th>Delete</th>
</tr>
<c:forEach var="consumersList" items="${consumersList}">
    <tr>
    <td>${consumersList.user.user_id}</td>
    <td>${consumersList.firstname}</td>
    <td>${consumersList.lastname}</td>
    <td>${consumersList.phoneNumber}</td>
    <td>${consumersList.email}</td>
    <td>${consumersList.counterpartyType}</td>
    <td><a href = "consumers/editConsumer/${consumersList.user.user_id}">Edit</a></td>
    <td><a href = "consumers/deleteConsumer/${consumersList.user.user_id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="consumers/addConsumer">Add consumer</a></br>
<a href="index.jsp" >Back to main page</a>
</body>
</html>
