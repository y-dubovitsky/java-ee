<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.11.2019
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <%!
        /**
         * This method read all from file and write it in response
         * @param file
         * @param response
         */
        public void readHtmlFile(File file, ServletResponse response) {
            try{
                List<String> strings = Files.readAllLines(file.toPath());
                PrintWriter writer = response.getWriter();
                for (String str : strings) {
                    writer.write(str);
                }
                writer.flush();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    %>
    <%-- invoke method --%>
    <%
        readHtmlFile(new File("C:\\Users\\user\\IdeaProjects\\java_ee\\web\\WEB-INF\\html\\error.html"), response);
    %>
</body>
</html>
