<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit role</title>
</head>
<body>
<h1>Edit role</h1>
<form:form method="POST" action="/roles/edit">
    <table >
    <tr>
    <td>Id :</td>
    <td><form:hidden path="id" /></td>
    </tr>
    <tr>
    <td>Name : </td>
    <td><form:input path="name" /></td>
    </tr>
    <td><input type="submit" value="Edit Save" /></td>
    </tr>
    </table>
 </form:form>
 </body>
 </html>