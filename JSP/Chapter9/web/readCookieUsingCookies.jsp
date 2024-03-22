<%@ page import="util.Cookies" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookies cookies = new Cookies(request);
%>
<html>
<head>
    <title>Cookie 사용</title>
</head>
<body>

name 쿠키 = <%= URLEncoder.encode(cookies.getValue("name"),"utf-8") %><br>
<% if (cookies.exists("id")) { %>
id 쿠키 = <%= cookies.getValue("id") %> <br>
<% } %>
</body>
</html>
