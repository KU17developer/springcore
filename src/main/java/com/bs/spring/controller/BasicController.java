package com.bs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/* 클라이언트에 요청을 받아서 처리하는 메소드를 갖고있는 클래스 */
/* 스프링 컨테이너에 의해서 돌아가기 위해선 빈으로 등록해야함 이렇게 @Controller */
@Controller
public class BasicController {

    // 매핑 메소드
    // 맨 처음 view안에 index.jsp 넣고 이렇게 설정해줘야 index 페이지를 찾아감!! (메인화면 연결!)
    @RequestMapping("/")
    public String index(HttpSession session, HttpServletResponse response) {

        // session 저장
        session.setAttribute("sessionId", "bsyoo");
        
        // Cookie 저장
        Cookie c = new Cookie("lunch", "pizza");
        c.setMaxAge(60*60*24);
        response.addCookie(c);



        System.out.println("index메소드 실행");
        return "index"; // /WEB-INF/views/ controller반환값 .jsp 이렇게 붙음. 그 후에 이 주소로 request.dispatcher().forward <- 서블릿에서 했던거 하는거임.
    }

}
