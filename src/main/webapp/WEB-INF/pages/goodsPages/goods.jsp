    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
    <title>Title</title>
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
    <p>Goods</p>

    <div>All goods types:</div>

    <table border="2" width="100%" cellpadding="2">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Price</th>
    <th>Goods type</th>
    <th>Supplier</th>
    <th>Edit</th>
    <th>Delete</th>
    </tr>
    <c:forEach var="goods" items="${goodsList}">
        <tr>
        <td>${goods.id}</td>
        <td>${goods.name}</td>
        <td>${goods.price}</td>
        <td>${goods.goodsType.name}</td>
        <td>${goods.supplier.organization}</td>
        <td><a href = "goods/editGoods/${goods.id}">Edit</a></td>
        <td><a href = "goods/deleteGoods/${goods.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
        <a href="goods/addGoods">Add goods</a></br>
        <a href="goodsType">Show goods types</a></br>
        <a href="index.jsp" >Back to main page</a>
        </font>
        </div>
    </body>
    </html>
