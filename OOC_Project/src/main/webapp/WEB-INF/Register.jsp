<%--
  Created by IntelliJ IDEA.
  User: maylin
  Date: 6/16/20
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<h2>
    Please register your username and password
</h2>
<body>
<p>
    ${error}
</p>
<p>
<form method="post">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
    <br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <br>
    <button type="submit" name="button" value="addUser">AddUser</button>
    <button onclick="location.href='http://localhost:8080/login'" type="button">
        Back</button>
</form>
</p>
</body>
</html>
