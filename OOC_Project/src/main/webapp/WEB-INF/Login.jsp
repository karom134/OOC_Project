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
    Welcome to Login Page
</h2>
<body>
<p>
    ${error}
</p>
<p>
<form method="post">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username">
    <br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password">
    <br>
    <br>
    <button type="submit" name="login">Login</button>
    <br>
    <button type="submit" name="register">Register</button>
    <br>
</form>
</p>
</body>
</html>
