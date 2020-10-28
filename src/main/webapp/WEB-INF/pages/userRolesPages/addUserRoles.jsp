    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>
        <head>
        <title>Add new user role</title>
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
        <h1>Add new user role</h1>
        <form:form method="POST" action="/userRoles/create">
            <table >
            <tr>
            <td>User id :</td>
            <td><form:input path="user.user_id" /></td>
            </tr>
            <tr>
            <td>Role id : </td>
            <td><form:input path="role.id" /></td>
            </tr>
            <td><input type="submit" value="Save" /></td>
            </tr>
            </table>
        </form:form>
        </font>
        </div>
        </body>
        </html>