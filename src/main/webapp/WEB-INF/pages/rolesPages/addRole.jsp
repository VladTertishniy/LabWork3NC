<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add new role</title>
</head>
<body>
<h1>Add new role</h1>
<form:form method="POST" action="/roles/create">
    <table >
    <tr>
    <td>Id :</td>
    <td><form:hidden path="id" /></td>
    </tr>
    <tr>
    <td>Name : </td>
    <td><form:input path="name" /></td>
    </tr>
    <td><input type="submit" value="Save" /></td>
    </tr>
    </table>
</form:form>
</body>
</html>