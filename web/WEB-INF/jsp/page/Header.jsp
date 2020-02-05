<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Paths" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <%!
        private void getHeader(Path path, ServletResponse response) throws Exception {
            PrintWriter writer = response.getWriter();
            Files.lines(path).forEach(writer::write);
            writer.flush();
        }
    %>

    <%-- output header --%>
    <%getHeader(Paths.get("C:\\Users\\user\\IdeaProjects\\java_ee\\web\\html\\header.html"), response);%>
</body>
</html>
