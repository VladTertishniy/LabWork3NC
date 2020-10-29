<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Order</title>
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
<h1>Your order id:</h1>
<form:form method="GET" action="/orders/redirect">
    <table >
    <tr>
    <td>Id :</td>
    <td><form:input path="id" readonly="readonly" /></td>
    </tr>
    </tr>
    <td><input type="submit" value="Ok" /></td>
    </table>
</form:form>
</font>
</div>
</body>
</html>