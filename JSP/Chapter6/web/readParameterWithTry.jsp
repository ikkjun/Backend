<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파라미터 출력</title>
</head>
<body>

name 파라미터 값:
<% try { %>
<%= request.getParameter("name").toUpperCase() %>
<% } catch(Exception ex) { %>
name 파라미터가 옳지 않습니다.
<% } %>
</body>
</html>
