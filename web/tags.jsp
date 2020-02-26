<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="java-tag" uri="/WEB-INF/tags/tags.tld"%>
<%@taglib prefix="java2-tag" uri="/WEB-INF/tags/tags2.tld" %>
<%@ taglib prefix="tag-files" tagdir="/WEB-INF/tags" %>
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
                border: 1px black solid;
                background-color: snow;
                margin: 20px;
            }
            .java-tag {
                border: 1px darkorchid solid;
                background-color: burlywood;
                margin: 20px;
            }
            .java2-tag {
                border: 1px crimson solid;
                background-color: lightpink;
                margin: 20px;
            }
            .tag-file {
                border: 1px cornflowerblue solid;
                background-color: gainsboro;
                margin: 20px;
            }
            .work {
                border: 1px peachpuff solid;
                background-color: springgreen;
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <div class="java-tag">
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
            <div class="container">
                <java-tag:SetDefaultParamTag attr="a">a</java-tag:SetDefaultParamTag>
                <java-tag:SetDefaultParamTag attr="b">b</java-tag:SetDefaultParamTag>
                <java-tag:SetDefaultParamTag attr="c">c</java-tag:SetDefaultParamTag>
            </div>
            <div class="container">
                <java-tag:LoopTag loop="5">Loop Tag</java-tag:LoopTag>
            </div>
            <div class="ChangeBodyContentTag">
                <java-tag:ChangeBodyContentTag>ChangeBodyContentTag</java-tag:ChangeBodyContentTag>
            </div>
            <%--<div class="container">--%>
                <%--<java-tag:skip/>--%>
            <%--</div>--%>
            <%--<h1>You will not see this string</h1>--%>
        </div>
        <div class="java2-tag">
            <div class="container">
                <java2-tag:StaticTag2/>
            </div>
            <div class="container">
                <java2-tag:AttrTag2 attr="5"></java2-tag:AttrTag2>
                <java2-tag:AttrTag2 attr="4"></java2-tag:AttrTag2>
            </div>
            <div class="container">
                <java2-tag:HTag2>HTag2</java2-tag:HTag2>
            </div>
            <div class="container">
                <java2-tag:LoopTag2 iterate="-1">LoopTag2</java2-tag:LoopTag2>
                <java2-tag:LoopTag2 iterate="10">LoopTag2</java2-tag:LoopTag2>
                <java2-tag:LoopTag2>LoopTag2</java2-tag:LoopTag2>
            </div>
            <div class="container">
                <java2-tag:ChangeBodyContentTag2>Tag Body Content</java2-tag:ChangeBodyContentTag2>
            </div>
            <div class="tag-file">
                <div class="container">
                    <tag-files:static></tag-files:static>
                </div>
                <div class="container">
                    <tag-files:iterable></tag-files:iterable>
                </div>
                <div class="container">
                    <tag-files:attr id="test" message="message"/>
                    <tag-files:attr>
                        <jsp:attribute name="id">test</jsp:attribute>
                        <jsp:attribute name="message"><span><strong>Hello world</strong></span></jsp:attribute>
                    </tag-files:attr>
                </div>
            </div>
        </div>
    </body>
</html>