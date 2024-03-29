<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String linkUrl = "/Logout";
    String linkName ="로그아웃";
    String id = (String) session.getAttribute("authUser");
    if(id==null || id.equals("")){
        linkUrl = "/loginForm.jsp";
        linkName =  "로그인";
    }
%>

<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-red w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="/" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
        <a href="<c:url value='${linkUrl}'>" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"><%=linkName%></a>
        <a href="<c:url value='/boardController/gotoPage'>" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Board</a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">개인정보수정</a>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
        <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
    </div>
</div>