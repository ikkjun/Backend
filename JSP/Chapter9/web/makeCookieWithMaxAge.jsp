<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("threesec", "Itime");
    cookie.setMaxAge(3);
    response.addCookie(cookie);
%>
<html>
<head>
    <title>쿠키유효시간설정</title>
</head>
<body>

유효시간이 3초인 threesec 쿠키 생성.

</body>
</html>
