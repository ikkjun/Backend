<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.setAttribute("MEMBERID", "madvirus");
  session.setAttribute("NAME", "조익준");
%>
<html>
<head>
    <title>세션에 정보 저장</title>
</head>
<body>
<%
  String name = (String)session.getAttribute("NAME");
%>
세션에 사용자 이름 <%= name %>을 저장하였습니다.
</body>
</html>
