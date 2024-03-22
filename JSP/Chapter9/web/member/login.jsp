<%@ page import="util.Cookies" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String id = request.getParameter("id");
  String passward = request.getParameter("password");

  if (id.equals(passward)) {
    response.addCookie(
            Cookies.createCookie("AUTH", id, "/", -1)
    );
%>
<html>
<head>
    <title>로그인성공</title>
</head>
<body>
로그인에 성공했습니다.
</body>
</html>
<%
  } else {
%>
  <script>
    alert("로그인에 실패했습니다.");
    history.go(-1);
  </script>
<%
  }
%>
