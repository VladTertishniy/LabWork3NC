<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Edit Goods page</title>
</head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"
    integrity="sha256-sPB0F50YUDK0otDnsfNHawYmA5M0pjjUf4TvRJkGFrI=" crossorigin="anonymous"></script>
    <script src="/files/goods.js"></script>
    <style>
    .text {
    text-align:  center;
    }
    </style>
<body>
    <img height="50%" width="100%" src="/files/top.png"/>
    <div class="text">
    <font size="10" color="black" face="algerian">
<h1>Edit goods:</h1>
<form:form id="goodsForm" method="POST" action="/goods/edit">
    <table >
    <tr>
    <td>Id :</td>
    <td><form:hidden path="id"/></td>
    </tr>
    <tr>
    <td>Name : </td>
    <td><form:input id="name" name="name" path="name" placeholder="Enter name of goods" /></td>
    </tr>
    <tr>
    <td>Price : </td>
    <td><form:input id="price" name="price" path="price" placeholder="Enter price of goods" /></td>
    </tr>
    <tr>
    <td>Goods type id : </td>
    <td><form:input id="goodsType.id" name="goodsType.id" path="goodsType.id" placeholder="Enter goods type id" /></td>
    </tr>
    <tr>
    <td>Supplier id : </td>
    <td><form:input id="supplier.user.user_id" name="supplier.user.user_id" path="supplier.user.user_id" placeholder="Enter supplier id" /></td>
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