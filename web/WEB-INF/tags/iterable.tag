<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag import="java.util.Date" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%!
    String date = new SimpleDateFormat("yyyy").format(new Date().getTime());
%>

<%
    for(int i = 0; i < 10; i++) {
        jspContext.getOut().println(date);
    }
%>