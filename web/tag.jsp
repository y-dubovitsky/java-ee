<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="java-tag" uri="/WEB-INF/tags.tld"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>The HTML5 Herald</title>
        <meta name="description" content="The HTML5 Herald">
        <meta name="author" content="SitePoint">
        <link rel="stylesheet" href="css/styles.css?v=1.0">
        <style>
            .container {
                border: 1px darkblue solid;
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <java-tag:static>
                <%
                    String username = request.getParameter("username");
                    if ( username != null && username.length() > 0 ) {
                %>
                <%
                    } else {
                        System.out.println("dsfdwgfdsgdsg");
                    }
                %>
            </java-tag:static>
        </div>
        <%--<div class="container">--%>
            <%--<java-tag:skip/>--%>
        <%--</div>--%>
        <div class="container">
            Jsp page content before starting tag.
            <java-tag:doStart>
                <br><b>contents displayed after the custom tag's
                start tag is encountered.</b>
            </java-tag:doStart>
            <br>Jsp page content after closing tag.
        </div>
        <div class="container">
            <br>out start;
            <java-tag:attr var="false">
                <h3>java-tag:attr var="false"</h3>
            </java-tag:attr>

            <java-tag:attr var="${ 2 > 1 }"/>

            <%
                int a = 0;
                int b =5;
            %>

            <java-tag:attr var="<%= a > b ? true : false %>"/>
            <br>out end
        </div>
        <div class="container">
            <java-tag:h type="h1">h1</java-tag:h>
            <java-tag:h type="h2">h2</java-tag:h>
            <java-tag:h type="h3">h3</java-tag:h>
            <java-tag:h type="h4">h4</java-tag:h>
            <java-tag:h type="h5">h5</java-tag:h>
        </div>
    </body>
</html>