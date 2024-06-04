package com.website.login.controller;

import com.website.login.UserDto;
import com.website.login.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserDao userDao;

    @GetMapping("/form")
    public String loginForm() {
        return "loginForm";
    }

    public boolean validateLogin(String id, String pwd) {
        UserDto userDto = null;
        try {
            userDto = userDao.select(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDto != null && userDto.getPwd().equals(pwd);
    }

    @PostMapping("/check")
    public String loginCheck(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String isRemember = request.getParameter("remember");
        String fromURL = request.getParameter("fromURL");
        String toURL = (String) request.getParameter("toURL");

        System.out.println("Login process Start");
        System.out.println("fromURL: " + fromURL);
        System.out.println("toURL: " + toURL);

        if (validateLogin(id, pwd)) {	// id와 pwd 일치하면
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
            System.out.println("LoginColtroller redirect URL: " + url);
            return "redirect:"+url;
        } else {
            return "redirect:/login/form";
        }
    }



    @GetMapping("/out")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
//        resp.sendRedirect("home.jsp");
        return "redirect:/";

    }
}