<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Не работают импорты тэгов --%>
<%@ taglib prefix="ownTag" tagdir="/WEB-INF/tag" %>
<%@ taglib prefix="tag" uri="/tld/TagDescriptor.tld" %>
<html>
<head>
    <title>My Own Tag</title>
</head>
<body>
    <%
        response.getWriter().write("Hello");
    %>
    <%-- Не работают тэги --%>
    <tag:Tag/>
    <ownTag:></ownTag:>
</body>
</html>
