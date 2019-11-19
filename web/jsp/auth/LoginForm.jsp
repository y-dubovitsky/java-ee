<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.11.2019
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form Page</title>
</head>
<body>
    <form action="j_security_check" method="post">
        Username:<input type="text" name="j_username">
        Password:<input type="password" name="j_password">
        <input type="submit" value="login">
    </form>
</body>
</html>
