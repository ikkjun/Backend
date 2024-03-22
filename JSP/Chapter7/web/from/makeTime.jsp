<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<%
  Calendar cal = Calendar.getInstance();
  request.setAttribute("time", cal);
%>
<jsp:forward page="/to/viewTime.jsp" />
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
