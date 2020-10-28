<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Edit supplier</title>
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
<h1>Edit supplier:</h1>
<form:form method="POST" action="/suppliers/edit">
    <table >
    <tr>
    <td>User id :</td>
    <td><form:input path="user.user_id" /></td>
    </tr>
    <tr>
    <td>Firstname : </td>
    <td><form:input path="firstname" /></td>
    </tr>
    <tr>
    <td>Lastname : </td>
    <td><form:input path="lastname" /></td>
    </tr>
    <tr>
    <td>Phone number : </td>
    <td><form:input path="phoneNumber"/></td>
    </tr>
    <tr>
    <td>Email : </td>
    <td><form:input path="email" /></td>
    </tr>
    <tr>
    <td>Organization : </td>
    <td><form:input path="organization" /></td>
    </tr>
    <tr>
    <td> </td>
    <td><input type="submit" value="Edit Save" /></td>
    </tr>
    </table>
</form:form>
    </font>
    </div>
</body>
</html>