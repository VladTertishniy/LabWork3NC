<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User roles</title>
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
<p>User roles</p>

<div>All user roles:</div>

<table border="2" width="100%" cellpadding="2">
<tr>
<th>Username</th>
<th>Role</th>
<th>User id</th>
<th>Role id</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="userRoleList" items="${userRoleList}">
    <tr>
    <td>${userRoleList.user.username}</td>
    <td>${userRoleList.role.name}</td>
    <td>${userRoleList.user.user_id}</td>
    <td>${userRoleList.role.id}</td>
    <td><a href = "userRoles/editUserRoles/${userRoleList.id}">Edit</a></td>
    <td><a href = "userRoles/deleteUserRoles/${userRoleList.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="userRoles/addUserRoles">Add user role</a></br>
<a href="index.jsp" >Back to main page</a>
    </font>
    </div>
</body>
</html>