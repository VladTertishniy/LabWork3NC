<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Roles</title>
</head>
<body>
<p>Role</p>
<div>All roles:</div>

<table border="2" width="100%" cellpadding="2">
<tr>
<th>Id</th>
<th>Name</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="rolesList" items="${rolesList}">
    <tr>
    <td>${rolesList.id}</td>
    <td>${rolesList.name}</td>
    <td><a href = "roles/editRole/${rolesList.id}">Edit</a></td>
    <td><a href = "roles/deleteRole/${rolesList.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="roles/addRole">Add role</a>
<a href="index.jsp" >Back to main page</a>
</body>
</html>