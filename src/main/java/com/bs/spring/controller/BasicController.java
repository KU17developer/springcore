package com.bs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/* 클라이언트에 요청을 받아서 처리하는 메소드를 갖고있는 클래스 */
@Controller
public class BasicController {

    // 매핑 메소드
    @RequestMapping("/")
    public String index(HttpSession session, HttpServletResponse response) {

        // session 저장
        session.setAttribute("sessionId", "bsyoo");
        
        // Cookie 저장
        Cookie c = new Cookie("lunch", "pizza");
        c.setMaxAge(60*60*24);
        response.addCookie(c);



        System.out.println("index메소드 실행");
        return "index"; // /WEB-INF/views/ controller반환값 .jsp 이렇게 붙음
    }

}
