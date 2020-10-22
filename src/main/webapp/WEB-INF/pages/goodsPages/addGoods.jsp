<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add new goods</title>
</head>
<body>
<h1>Add new goods</h1>
<form:form method="POST" action="/goods/create">
    <table >
    <tr>
    <td>Id :</td>
    <td><form:hidden path="id" /></td>
    </tr>
    <tr>
    <td>Name : </td>
    <td><form:input path="name" /></td>
    </tr>
    <tr>
    <td>Price id : </td>
    <td><form:input path="price" /></td>
    </tr>
    <tr>
    <td>Goods type id : </td>
    <td><form:input path="goodsType.id"/></td>
    </tr>
    <tr>
    <td>Supplier id : </td>
    <td><form:input path="supplier.user.user_id" /></td>
    </tr>
    <tr>
    <td> </td>
    <td><input type="submit" value="Save" /></td>
    </tr>
    </table>
</form:form>
</body>
</html>