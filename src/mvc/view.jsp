<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.11.2019
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is the view</title>
</head>
<body>
<jsp:useBean id="Bean" class= "mvc.beans.Person" scope="session"/>
<jsp:getProperty name="Bean" property="name"/>
</body>
</html>