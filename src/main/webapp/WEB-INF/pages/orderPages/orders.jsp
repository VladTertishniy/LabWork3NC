<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
    <title>Orders</title>
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
    <p>Orders</p>
    <div>All orders:</div>

    <table border="2" width="100%" cellpadding="2">
    <tr>
    <th>Id</th>
    <th>Number</th>
    <th>Consumer</th>
    <th>Date</th>
    <th>Edit</th>
    <th>Delete</th>
    </tr>
    <c:forEach var="ordersList" items="${ordersList}">
        <tr>
        <td>${ordersList.id}</td>
        <td>${ordersList.number}</td>
        <td>${ordersList.consumer}</td>
        <td>${ordersList.orderDate}</td>
        <td><a href = "orders/deleteOrder/${ordersList.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    <a href="index.jsp" >Back to main page</a>
    </font>
    </div>
    </body>
    </html>