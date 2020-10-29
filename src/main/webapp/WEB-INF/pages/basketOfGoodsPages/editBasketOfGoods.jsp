<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Edit basket of goods</title>
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
<h1>Edit basket of goods:</h1>
<form:form method="POST" action="/basketOfGoods/edit">
    <table >
    <tr>
    <td>Goods id :</td>
    <td><form:hidden path="goods.name"/></td>
    </tr>
    <tr>
    <td>Order id : </td>
    <td><form:hidden path="order.id"/></td>
    </tr>
    <tr>
    <td>Count : </td>
    <td><form:input path="count"/></td>
    </tr>
    <tr>
    <td>Sum : </td>
    <td><form:input path="sum"/></td>
    </tr>
    <tr>
    <td><input type="submit" value="Edit Save" /></td>
    </tr>
    </table>
</form:form>
</font>
</div>
</body>
</html>