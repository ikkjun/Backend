<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="member" scope="request" class="chap08.member.MemberInfo" />
<%
  member.setId("ikjun");
  member.setName("조익준");
%>
<jsp:forward page="/useObject.jsp" />