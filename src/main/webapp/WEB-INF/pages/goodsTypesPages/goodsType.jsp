    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <html>
    <head>
    <title>Goods types</title>
    </head>
    <body>
    <p>GoodsType</p>
    <div>All goods types:</div>

    <table border="2" width="100%" cellpadding="2">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Parent id</th>
    <th>Vendor code</th>
    <th>Edit</th>
    <th>Delete</th>
    </tr>
    <c:forEach var="goodsType" items="${goodsTypeList}">
        <tr>
        <td>${goodsType.id}</td>
        <td>${goodsType.name}</td>
        <td>${goodsType.parent_id}</td>
        <td>${goodsType.vendorCode}</td>
        <td><a href = "goodsType/editGoodsType/${goodsType.id}">Edit</a></td>
        <td><a href = "goodsType/deleteGoodsType/${goodsType.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
        <a href="goodsType/addGoodsType">Add goods type</a></br>
        <a href="index.jsp" >Back to main page</a>
    </body>
    </html>
