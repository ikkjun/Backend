package Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
    /**
     *
     * @param request request를 받는 매개변수
     * @return 로그인 여부를 반환한다.
     */
    public boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);                                      // 세션이 없을 때 새로 생성하지 않는다.
        if (session != null)
            return session.getAttribute("authUser") != null;
        return false;
    }

    /**
     *
     * @param request request를 받는 매개변수
     * @return  로그인 여부에 따라 가야 할 페이지를 반환한다.
     */
    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request) {
        System.out.println("BoardController 도착");
        String toURL = String.valueOf(request.getRequestURL());
        if (loginCheck(request)) {    // 로그인이 되어 있다면 가야 할 페이지로 이동
            return "boardList";
        } else {                    // 로그인이 되어 있지 않다면 로그인 페이지로 이동
            return "redirect:/loginForm.jsp?toURL="+toURL.substring(1);
        }
    }
}