    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>
        <head>
        <title>Add new user role</title>
        </head>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"
        integrity="sha256-sPB0F50YUDK0otDnsfNHawYmA5M0pjjUf4TvRJkGFrI=" crossorigin="anonymous"></script>
        <script src="/files/userRoles.js"></script>
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
        <form:form  id="userRolesForm" method="POST" action="/userRoles/create">
            <table >
            <tr>
            <td>User id :</td>
            <td><form:input id="userId" name="user.user_id" path="user.user_id" placeholder="Enter user id" /></td>
            </tr>
            <tr>
            <td>Role id : </td>
            <td><form:input id="role.id" name="role.id" path="role.id" placeholder="Enter role id" /></td>
            </tr>
            <td><input type="submit" value="Save" /></td>
            </tr>
            </table>
        </form:form>
        </font>
        </div>
        </body>
        </html>