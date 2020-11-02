<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
    <title>Add new goods type</title>
    </head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"
    integrity="sha256-sPB0F50YUDK0otDnsfNHawYmA5M0pjjUf4TvRJkGFrI=" crossorigin="anonymous"></script>
    <script src="/files/goodsType.js"></script>
    <style>
    .text {
    text-align:  center;
    }
    </style>
    <body>
    <img height="50%" width="100%" src="/files/top.png"/>
    <div class="text">
    <font size="10" color="black" face="algerian">
    <h1>Add new goods type</h1>
    <form:form id="goodsTypeForm" method="POST" action="/goodsType/create">
        <table >
        <tr>
        <td>Id :</td>
        <td><form:hidden path="id" /></td>
        </tr>
        <tr>
        <td>Name : </td>
        <td><form:input id="name" name="name" path="name" placeholder="Enter name of goods" /></td>
        </tr>
        <tr>
        <td>Parent id : </td>
        <td><form:input id="parent_id" name="parent_id" path="parent_id" placeholder="Enter parent goods type" /></td>
        </tr>
        <tr>
        <td>Vendor code : </td>
        <td><form:input id="vendorCode" name="vendorCode" path="vendorCode" placeholder="Enter vendor code" /></td>
        </tr>
        <tr>
        <td> </td>
        <td><input type="submit" value="Save" /></td>
        </tr>
        </table>
    </form:form>
    </font>
    </div>
    </body>
    </html>