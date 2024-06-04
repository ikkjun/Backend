package com.website.login.controller;

import com.website.login.BoardDto;
import com.website.login.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardDao boardDao;
    /**
     *
     * @param request request를 받는 매개변수
     * @return 로그인 여부를 반환한다.
     */
    public boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);                                      // 세션이 없을 때 새로 생성하지 않는다.
        if (session != null) {
            System.out.println("로그인한 기록이 있다.");
            return session.getAttribute("authUser") != null;
        } else {
            System.out.println("로그인한 기록이 없다");
            return false;
        }
    }

    /**
     *
     * @param request request를 받는 매개변수
     * @return  로그인 여부에 따라 가야 할 페이지를 반환한다.
     */
    @GetMapping("/list")
    public String boardPage(HttpServletRequest request) {
        System.out.println("BoardController 도착");
        String toURL = String.valueOf(request.getRequestURI());
        if (loginCheck(request)) {    // 로그인이 되어 있다면 가야 할 페이지로 이동
            return "boardList";
        } else {                    // 로그인이 되어 있지 않다면 로그인 페이지로 이동
            System.out.println("BoardController.java toURL: " + toURL);
            return "redirect:/login/form?toURL="+toURL;
        }
    }

    // read 읽기
    @GetMapping("/read")
    public String readBoard(HttpServletRequest request, Model m) {
        BoardDto boardDto = null;
        int boardno = Integer.parseInt(request.getParameter("boardno"));
        System.out.println("boardno= " + boardno);
        try {
            boardDto = boardDao.select(boardno);
            m.addAttribute("boardDto",boardDto );
            System.out.println("boardDto = " + boardDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "boardList";
    }

    // BoardDao read해서 화면에 보여주기
}