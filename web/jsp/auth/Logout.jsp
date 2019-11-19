<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%!
    private void logout(HttpSession session) {
        session.invalidate();
    }
%>
<body>
    <form action=<%logout(session);%>; method="post">
        <input type="submit" value="Exit">
    </form>
</body>
</html>
