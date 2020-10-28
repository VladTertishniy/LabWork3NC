<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Users</title>
</head>
<body>
<p>Users</p>
<div>All users:</div>

<table border="2" width="100%" cellpadding="2">
<tr>
<th>Id</th>
<th>Username</th>
<th>Password</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="usersList" items="${usersList}">
    <tr>
    <td>${usersList.user_id}</td>
    <td>${usersList.username}</td>
    <td>${usersList.password}</td>
    <td><a href = "users/editUser/${usersList.user_id}">Edit</a></td>
    <td><a href = "users/deleteUser/${usersList.user_id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="users/addUser">Add user</a></br>
<a href="index.jsp" >Back to main page</a>
</body>
</html>