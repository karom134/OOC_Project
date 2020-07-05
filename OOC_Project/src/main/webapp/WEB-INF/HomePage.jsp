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
<form method="post" id="save-form" action="save">
    <input type="hidden" id="action" name="action" />
    <button type="submit" name="MenuGetIngredient" id="MenuGetIngredient"></button>
    <br>
    <button type="submit" name="IngredientGetMenu" id="IngredientGetMenu"></button>
    <br>
</form>
<script>
    $('#MenuGetIngredient').on('click', function(){$('#action').val('MenuGetIngredient'); $('#save-form').submit();});
    $('#IngredientToMenu.jsp').on('click', function(){$('#action').val('IngredientToMenu.jsp'); $('#save-form').submit();});
</script>
</p>
</body>
</html>
