<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add new user</title>
</head>
<body>
<h1>Add new user</h1>
<form:form method="POST" action="/users/create">
    <table >
    <tr>
    <td>Id :</td>
    <td><form:hidden path="user_id" /></td>
    </tr>
    <tr>
    <td>Username : </td>
    <td><form:input path="username" /></td>
    </tr>
    <tr>
    <td>Password : </td>
    <td><form:input path="password" /></td>
    </tr>
    <td><input type="submit" value="Save" /></td>
    </tr>
    </table>
</form:form>
</body>
</html>