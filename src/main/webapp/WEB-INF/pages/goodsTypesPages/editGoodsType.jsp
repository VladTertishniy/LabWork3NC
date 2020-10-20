<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
    <title>Edit GoodsType's page</title>
    </head>
    <body>
    <h1>Edit Goods type</h1>
    <form:form method="POST" action="/goodsType/edit">
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
        <td>Parent id : </td>
        <td><form:input path="parent_id" /></td>
        </tr>
        <tr>
        <td>Vendor code : </td>
        <td><form:input path="vendorCode" /></td>
        </tr>
        <tr>
        <td> </td>
        <td><input type="submit" value="Edit Save" /></td>
        </tr>
        </table>
    </form:form>
    </body>
    </html>