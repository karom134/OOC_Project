<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login Page</title>
</head>
<h2>
    Get Your Menu by Ingredient !!
</h2>
<body>
<p>
    ${display}
</p>
<p>
<form method="post">
    <label for="Ingredient"><b>Ingredient</b></label>
    <input type="text" placeholder="Enter Ingredient" name="IngredientName" required>
    <br>
    <br>
    <button type="submit" name="button" value="sentInfo">Sent</button>
    <button onclick="location.href='http://localhost:8080/home'" type="button">
        Back</button>
    <br>
</form>
</p>
</body>
</html>