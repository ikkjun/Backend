<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("name", "조익준");
%>
<html>
<head>
    <title>EL Object</title>
</head>
<body>

요청 URI: ${pageContext.request.requestURI}<br>
request의 name 속성: ${requestScope.name}<br>
code 파라미터: ${param.code}
</body>
</html>
