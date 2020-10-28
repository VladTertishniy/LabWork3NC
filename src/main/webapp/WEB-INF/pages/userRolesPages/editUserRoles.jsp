<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Edit user roles</title>
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
<h1>Edit user roles:</h1>
<form:form method="POST" action="/userRoles/edit">
    <table >
    <tr>
    <td>User id :</td>
    <td><form:input path="user.user_id" /></td>
    </tr>
    <tr>
    <td>Role id : </td>
    <td><form:input path="role.id"/></td>
    </tr>
    <tr>
    <td><input type="submit" value="Edit Save" /></td>
    </tr>
    </table>
</form:form>
    </div>
    </body>
</body>
</html>