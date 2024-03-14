<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    java.util.Calendar cal = java.util.Calendar.getInstance();
%>
<html>
<head>
    <title>Calendar 클래스 사용</title>
</head>
<body>
오늘은
<%=cal.get(java.util.Calendar.YEAR)%>년
<%=cal.get(java.util.Calendar.MONTH) + 1%>월
<%=cal.get(java.util.Calendar.DATE)%>일
입니다.
</body>
</html>
