<%--<%--%>
<%--String message = pageContext.getException().getMessage();--%>
<%--String exception = pageContext.getException().getClass().toString();--%>
<%--%>--%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Exception</title>
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
    <h2>Oops, some unexpected problem occurred...</h2>
<%--    <p>Type: <%= exception%></p>--%>
<%--    <p>Message: <%= message %></p>--%>
    <a href="/index.jsp" >Back to main page</a>
    </font>
    </div>
    </body>
    </html>