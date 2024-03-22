<%@ page import="util.Cookies" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.addCookie(Cookies.createCookie("name", "조익준"));
    response.addCookie(Cookies.createCookie("id", "ikjun", "chap09", -1));
%>
<html>
<head>
    <title>Cookies 사용 예</title>
</head>
<body>
Cookies를 사용하여 쿠키 생성
</body>
</html>
