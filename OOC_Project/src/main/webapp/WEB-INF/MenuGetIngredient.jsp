<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login Page</title>
</head>
<h2>
    Get Your Ingredient by The Menu !!
</h2>
<body>
<p>
    ${display}
</p>
<p>
<form method="post">
    <label for="Menu"><b>Menu</b></label>
    <input type="text" placeholder="Enter Menu" name="menuName" required>
    <br>
    <br>
    <button type="submit" name="button" value ="getMenu">Sent</button>
    <button onclick="location.href='http://localhost:8080/home'" type="button">
        Back</button>
    <br>
</form>
</p>
</body>
</html>