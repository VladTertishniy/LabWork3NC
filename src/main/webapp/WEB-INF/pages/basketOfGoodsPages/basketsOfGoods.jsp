<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>basket of goods</title>
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
<p>Basket of goods</p>
<div>All baskets of goods:</div>

<table border="2" width="100%" cellpadding="2">
<tr>
<th>Goods</th>
<th>Order</th>
<th>Count</th>
<th>Sum</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="basketOfGoodsList" items="${basketOfGoodsList}">
        <tr>
        <td>${basketOfGoodsList.goods.name}</td>
        <td>${basketOfGoodsList.order.number}</td>
        <td>${basketOfGoodsList.count}</td>
        <td>${basketOfGoodsList.sum}</td>
        <td><a href = "basketOfGoods/editBasketOfGoods/${basketOfGoodsList.goods.id}/${basketOfGoodsList.order.id}">Edit</a></td>
        <td><a href = "basketOfGoods/deleteBasketOfGoods/${basketOfGoodsList.goods.id}/${basketOfGoodsList.order.id}">Delete</a></td>
        </tr>
</c:forEach>
</table>
<a href="index.jsp" >Back to main page</a>
</font>
</div>
</body>
</html>