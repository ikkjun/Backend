<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%--    <jsp:include page="charCSS.css" flush="false"/>--%>
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <jsp:include page="topMenu.jsp" flush="false"/>
    <script>
        function goBack() {                                                  // 이전 페이지로 가는 함수이다.
            window.history.back();
        }
    </script>

    <h2>Login Form</h2>

    <form action="/LoginController" method="post">
        <div class="container">
            <label><b>아이디</b></label>
            <input type="text" placeholder="아이디를 입력해주세요" name="id" value="${cookie.authUser.value}" autofocus required >

            <label><b>비밀번호</b></label>
            <input type="password" placeholder="비밀번호를 입력해주세요" name="pwd" required>

            <button type="submit">Login</button>
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
            <input type="hidden" name="fromURL" value=${request.getHeader("referer")}/>
            <input type="hidden" name="toURL" value="${param.toURL}">
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="cancelbtn" onclick="goBack()">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
    <jsp:include page="footer.jsp" flush="false"/>
</body>
</html>

<%
    System.out.println("loginForm.jsp - request.getParameter(\"toURL\"): " + request.getParameter("toURL"));
    System.out.println("loginForm.jsp - request.getHeader(\"refer\"): " + request.getHeader("referer"));
%>