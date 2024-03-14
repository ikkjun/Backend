<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>헤더 목록 출력</title>
</head>
<body>
<%
  Enumeration headerEnum = request.getHeaderNames();
  while(headerEnum.hasMoreElements()) {
    String headerName = (String)headerEnum.nextElement();
    String headerValue = request.getHeader(headerName);
%>
<%= headerName %> = <%= headerValue %><br>
<%
  }
%>
</body>
</html>
