<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int sum = 0;
  for (int i=1;i<=10;i++) {
    sum += i;
  }
%>
<%
  int sum2 = 0;
  for (int i = 11 ; i <= 20 ; i++) {
    sum2 += i;
  }
%>
<html>
<head>
    <title>합 구하기</title>
</head>
<body>
1부터 10까지의 합은 <%=sum%>입니다.<br>
11부터 20까지의 합은 <%=sum2%>입니다.
</body>
</html>
