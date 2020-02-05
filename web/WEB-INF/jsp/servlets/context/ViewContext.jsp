<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.11.2019
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Context</title>
</head>
<body>
    <jsp:useBean id="first" class="ee.servlets.context.SimpleBean" scope="application"/>
    <jsp:getProperty name="first" property="name"/>
    <jsp:useBean id="second" class="ee.servlets.context.SimpleBean" scope="application"/>
    <jsp:getProperty name="second" property="name"/>
</body>
</html>
