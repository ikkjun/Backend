<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>layout1</title>
</head>
<body>

<table width="400" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2">
      <jsp:include page="/module/top.jsp" flush="false"/>
    </td>
  </tr>
  <tr>
    <td width="100" valign="top">
      <jsp:include page="/module/left.jsp" flush="false"/>
    </td>
    <td width="300" valign="top">
      <!-- 내용 부분 시작 -->
      이 부분은 layout2.jsp가 생성한다.
      레이아웃 2
      <br><br><br>
      <!-- 내용 부분: 끝-->
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <jsp:include page="/module/bottom.jsp" flush="false"/>
    </td>
  </tr>
</table>
</body>
</html>
