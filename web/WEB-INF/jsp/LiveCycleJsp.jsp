<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.11.2019
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Live Cycle</title>
</head>
<body>
    <%!
        public void jspInit() {
            System.out.println("Hello from JspInit");
        }

        public void jspDestroy() {
            System.out.println("Hello from Destroy");
        }
    %>
</body>
</html>
