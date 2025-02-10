package com.bs.spring.common.interceptor;

import com.bs.spring.member.model.dto.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// 빈으로 등록!
@Component("loginCheck")
public class LoginCheckInterceptor implements HandlerInterceptor {

    // 컨트롤러 메소드가 실행되기 전에 체크!

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 로그인 체크하기
        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember == null) {
            request.setAttribute("msg", "로그인 후 이용할 수 있습니다.");
            request.setAttribute("loc", "/");
            request.getRequestDispatcher("WEB-INF/views/common/msg.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    // 인터셉트에서 중복로그인 확인도 가능함! 캐시에 로그인한 사용자 저장해서!
}
