<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Init Param JSP</title>
</head>
<body>
<%-- Method decloration --%>
<%!
    public void getAllInitParams(ServletConfig config) {
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println(name + " : " + config.getInitParameter(name));
        }
    }

    private void getContextParam(ServletContext context) {
        Enumeration<String> initParameterNames = context.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println(name + " : " + context.getInitParameter(name));
        }
    }

%>
<%-- Invoke method --%>
<% getAllInitParams(config);%>

<%-- Invoke one more method --%>
<% getContextParam(config.getServletContext());%>
</body>
</html>
