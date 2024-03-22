<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include 디렉티브</title>
</head>
<body>

<%
  int number = 10;
%>

<%@ include file="/includee.jsp" %>

공통변수 DATAFOLDER = "<%= dataFolder %>"

</body>
</html>
