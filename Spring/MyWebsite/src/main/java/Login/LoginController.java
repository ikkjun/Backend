package Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String isRemember = request.getParameter("remember");
        String fromURL = request.getParameter("fromURL");
        String toURL = (String) request.getParameter("toURL");

        System.out.println("fromURL: " + fromURL);
        System.out.println("toURLPar: " + toURL);

        System.out.println("Login process Start");

        if (id.equals(pwd)) {	// id와 pwd 일치하면
            HttpSession session = request.getSession();	// session 생성
            session.setAttribute("authUser", id);	// session의 authUser속성을 id로 설정

            if(isRemember!=null && isRemember.equals("on")) {	// 체크박스가 체크되어 있다면
                Cookie cookie = new Cookie("authUser",id);	// authUser를 속성으로 갖는 쿠키 생성
                response.addCookie(cookie);					// 응답에 쿠키 추가
            } else {										// 체크박스가 체크되어 있지 않다면
                Cookie cookie = new Cookie("authUser",id);	// 쿠키에 authUser 저장
                cookie.setMaxAge(0);						// 쿠키의 유효기간 0으로 설정
                response.addCookie(cookie);					// 응답에 쿠키 추가
            }

            System.out.println("Login Success");
            String url = "";    // 연결될 url을 저장하는 변수
            if (toURL=="") {    // 가야 할 url이 저장되어 있지 않다면
                url = fromURL;  // url에 이전 페이지 저장
            } else {            // 가야 할 url이 저장되어 있다면
                url = toURL;    // url에 가야 할 페이지 저장
            }
            System.out.println("url"+url);
            response.sendRedirect(url);
            System.out.println("LoginColtroller redirect URL: " + url);
        } else {
//            String errorMessage = "로그인을 다시 시도하세요."; // 원하는 에러 메시지 설정
//            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
//            response.sendRedirect("/loginForm.jsp");
        }
    }
}