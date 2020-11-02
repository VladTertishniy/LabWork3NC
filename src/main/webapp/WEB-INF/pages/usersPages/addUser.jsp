<%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <html>
   <head>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"
   integrity="sha256-sPB0F50YUDK0otDnsfNHawYmA5M0pjjUf4TvRJkGFrI=" crossorigin="anonymous"></script>
   <script src="/files/user.js"></script>
   <title>Add new user</title>
   </head>
   <style>
   .text {
   text-align: center;
   }
   </style>
   <body>
   <img height="50%" width="100%" src="/files/top.png"/>
   <div class="text">
   <font size="10" color="black" face="algerian">
   <h1>Add new user</h1>
   <form:form id="userForm" method="POST" action="/users/create">
       <table >
       <tr>
       <td>Id :</td>
       <td><form:hidden path="user_id"/></td>
       </tr>
       <tr>
       <td>Username : </td>
       <td><form:input type="username" id="username" name="username" path="username" placeholder="Enter username"/></td>
       </tr>
       <tr>
       <td>Password : </td>
       <td><form:input type="password" id="password" name="password" path="password" placeholder="Enter password"/></td>
       </tr>
       <td><input type="submit" value="Save" /></td>
       </tr>
       </table>
   </form:form>
   </font>
   </div>
   </body>
   </html>