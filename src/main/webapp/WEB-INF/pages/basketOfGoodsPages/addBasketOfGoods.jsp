<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add new basket of goods</title>
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
<h1>Add new basket of goods</h1>
<form:form method="POST" action="/basketOfGoods/create">
    <table >
    <tr>
    <td>Order id  :</td>
    <td><form:input path="order.id" /></td>
    </tr>
    <tr>
    <td>Goods id : </td>
    <td><form:input path="goods.id" /></td>
    </tr>
    <tr>
    <td>Count : </td>
    <td><form:input path="count" /></td>
    </tr>
    <tr>
    <td>Sum id : </td>
    <td><form:input path="sum"/></td>
    </tr>
    <tr>
<%--    <td>Supplier id : </td>--%>
<%--    <td><form:input path="supplier.user.user_id" /></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
    <td><input type="submit" value="Save" /></td>
    </tr>
    </table>
</form:form>
</font>
</div>
</body>
</html>