<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Directive Page and Include</title>
</head>
<body>
<!-- File -->
<jsp:include page="/WEB-INF/resources/html.txt"/>

<!-- this is a directive ee.jsp -->
<jsp:include page="/hello"/>
<jsp:include page="Temp.jsp"/>

<!-- page import -->
<%= new Date()%>

<!-- bad practice -->
<%@ include file="Temp.jsp"%>
<%
    Body body = new Body("Your body, my Body, everybody move your body!");
%>
<%= body.somebody%>

<!-- We uses predefined variables -->
<%= request.getQueryString()%>

<!-- Try send file -->
<%
    PrintWriter writer = response.getWriter();
    writer.write("Hello from PrintWriter");
    writer.flush();
%>
</body>
</html>
