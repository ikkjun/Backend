<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%
    Cookie cookie = new Cookie("name", URLEncoder.encode("조익준", "utf-8"));
    response.addCookie(cookie);
%>
<html>
<head>
    <title>쿠키 생성</title>
</head>
<body>

<%= cookie.getName() %> 쿠키의 값 = "<%= cookie.getValue() %>"

</body>
</html>
