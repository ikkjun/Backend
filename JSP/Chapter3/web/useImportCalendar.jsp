<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.Calendar"%>
<%
  Calendar cal = Calendar.getInstance();
%>
<html>
<head>
    <title>Calendar 클래스 사용</title>
</head>
<body>
오늘은
<%=cal.get(Calendar.YEAR)%>년
<%=cal.get(Calendar.MONTH) + 1%>월
<%=cal.get(Calendar.DATE)%>일
입니다.
</body>
</html>
