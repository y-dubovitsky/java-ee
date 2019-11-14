<%@ page import="jsp.beans.Person" %>
<%@ page import="jsp.beans.Name" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beans</title>
</head>
<body>
    <%-- Внимательно посмотри как работать тут с бином --%>
    <%-- Set Prop --%>
    <jsp:useBean id="firstPerson" class="jsp.beans.Person" scope="page"/> <%-- Этот бин виден только на этой страницу --%>
    <%
        Name name = new Name();
        name.setFirstName("Brave");
        name.setSecondName("Rati");
    %>
    <jsp:setProperty name="firstPerson" property="id" value="1"/>
    <jsp:setProperty name="firstPerson" property="name" value="<%=name%>"/>
    <%
        firstPerson.setLongevity(14L);
    %>

    <%-- Get properties --%>
    <jsp:getProperty name="firstPerson" property="name"/>
    <%
        firstPerson.getName().getFirstName();
    %>

    <%-- New Bean! Не понял зачем указывать тип, наверное для полиморфизма, чтобы этот бин можно было в другой отдавать --%>
    <jsp:useBean id="thread" class="jsp.beans.MyThread" type="java.lang.Runnable"/>
    <%
        thread.run();
    %>

    <%-- Another bean with injection another bean --%>
    <jsp:useBean id="smartBeam" class="jsp.beans.SmartBean" scope="session"/>
    <jsp:setProperty name="smartBeam" property="runnable" value="<%=thread%>"/>
    <jsp:getProperty name="smartBeam" property="runnable"/>

    <%-- Beand with all visible --%>
    <jsp:useBean id="visibleName" class="jsp.beans.Name" scope="application"/>
    <jsp:setProperty name="visibleName" property="firstName" value="FIRST_NAME"/>
    <jsp:setProperty name="visibleName" property="firstName" value="SECOND_NAME"/>
</body>
</html>
