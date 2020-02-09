<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is the view</title>
</head>
<body>
    <jsp:useBean id="person" class= "ee.servlets.mvc.beans.Person" scope="session"/>
    <jsp:getProperty name="person" property="name"/>

    <%-- second bean --%>
    <jsp:useBean id="person1" class="ee.servlets.mvc.beans.Person" scope="application"/>
    <jsp:getProperty name="person1" property="name"/>

    <%-- third bean --%>
    <jsp:useBean id="person3" class="ee.servlets.mvc.beans.Person" scope="page"/>
    <jsp:getProperty name="person3" property="name"/>
</body>
</html>