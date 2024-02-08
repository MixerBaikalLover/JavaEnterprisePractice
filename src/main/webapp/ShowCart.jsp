<%@ page import="ru.mixer.javaenterprisepractice.logic.Cart" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            out.println(cart.toString());
        %>
</body>
</html>
