<%@ page import="ee.jsp.JspTemp" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.11.2019
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Hello World</H1>
<!-- This is a declaration -->
<%! private String gap = " To change this template use File | Settings | File Templates.\n;";%>

<!-- This is a scriptlet -->
<%
class Java {
    int version;
    private String name;

    public Java(int version, String name) {
        this.version = version;
        this.name = name;
    }


    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.version;
    }
}%>

<!-- This is a html -->
<h2>Hello from h2</h2>

<!-- This is an expression -->
<%=new Java(11, "Matthey").toString()%>
<%=new Java(11, gap).toString()%>

<!-- This is a scriptlet -->
<% if (Math.random() > 0.5) { %>
    System.out.println("RANDOM");
<%}; %>

<!-- This is an declaration -->
<%! class Body {
    private String somebody;

    public Body(String somebody) {
        this.somebody = somebody;
    }

    private String method(String s) {
        return s;
    }
}%>

<!-- This is just like this: resp.getWriter.write(/// some text); -->
<%= new Body("I like to move it move it").method("I sing a song")%>

<!-- This is an declaration -->
<%! class Nobody {
    private String name;
    private int age;

    public Nobody(String str, int age) {
        this.name = str;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}%>

<!-- This is an expression -->
<%= new Nobody("Nobody", 1_1_1_1)%>

<!-- How we can use package ee.jsp.JspTemp -->
<%= JspTemp.output()%>

<H1> This is the end =) oooo =)</H1>
</body>
</html>
