<%--
  Created by IntelliJ IDEA.
<%--
  Created by IntelliJ IDEA.
  User: maylin
  Date: 6/15/20
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<h2>
    Welcome to Home Page
</h2>
<body>
<p>
    ${error}
</p>
<p>
<form method="post">
    <button type="submit" name="button" value="getIng">GetIngredient</button>
    <button type="submit" name="button" value="getMenu">GetMenu</button>
    <button onclick="location.href='http://localhost:8080/login'" type="button">
        LogOut</button>
    <br>
</form>
</p>
</body>
</html>
