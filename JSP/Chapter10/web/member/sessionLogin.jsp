<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String id = request.getParameter("id");
  String password = request.getParameter("password");

  if(id.equals(password)) {
    session.setAttribute("MEMBERID", id);
%>
<html>
<head>
    <title>로그인성공</title>
</head>
<body>
로그인에 성공하였습니다.
<%
  } else {  // 로그인 실패시
%>
<script>
  alert("로그인에 실패하였습니다.");
  history.go(-1);
</script>
<%
  }
%>
</body>
</html>
