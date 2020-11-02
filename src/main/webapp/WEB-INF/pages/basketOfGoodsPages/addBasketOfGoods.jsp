<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add new basket of goods</title>
</head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"
    integrity="sha256-sPB0F50YUDK0otDnsfNHawYmA5M0pjjUf4TvRJkGFrI=" crossorigin="anonymous"></script>
    <script src="/files/basketOfGoods.js"></script>
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
<form:form id="basketOfGoodsForm" method="POST" action="/basketOfGoods/create">
    <table >
    <tr>
    <td>Order id  :</td>
    <td><form:input id="orderId" name="order.id" path="order.id" placeholder="Enter order id" /></td>
    </tr>
    <tr>
    <td>Goods id : </td>
    <td><form:input id="goodsId" name="goods.id" path="goods.id" placeholder="Enter goods id" /></td>
    </tr>
    <tr>
    <td>Count : </td>
    <td><form:input id="count" name="count" path="count" placeholder="Enter count" /></td>
    </tr>
    <tr>
    <td>Sum : </td>
    <td><form:input id="sum" name="sum" path="sum" placeholder="Enter sum" /></td>
    </tr>
    <tr>
    <td><input type="submit" value="Save" /></td>
    </tr>
    </table>
</form:form>
</font>
</div>
</body>
</html>