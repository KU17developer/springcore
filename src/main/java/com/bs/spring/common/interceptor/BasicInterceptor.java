package com.bs.spring.common.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicInterceptor implements HandlerInterceptor {

    // ctrl + o 단축키 눌러서 추상메소드들 전부 가져오기

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("인터셉터 실행! prehandle");

        // 요청주소 확인하기 ( 어디로 넘어갈때 캐치 했는지 보기 )
        // 파라미터(넘어오는 값이)가 있으면 request로 확인할 수도 있음!
        // 만약 어떤 쿠키값을 저장하고 싶으면 쿠키 생성해서 reponse.addCookie도 이용할 수 있음!
        System.out.println("요청 주소 : " + request.getRequestURI());

        // 핸들러 라는 Object는 넘어갈때 그 해당하는 controller 클래스가 뭐고 실행되는 메소드가 뭔지 확인할 수 있다!
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 오브젝트를 반환 ( 클래스 이름을 알아보자 )
        System.out.println(handlerMethod.getBean().getClass().getName());

        // 메소드 이름을 알아보자 ( 리플렉스 메소드 반환 )
        System.out.println(handlerMethod.getMethod().getName());
        
        // true 면넘어가고 false면 안넘어가고
        return true;
    }


    // void 형이기에 따로 반환하는건 없음.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        System.out.println("인터셉터 실행! posthandle");
        

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("인터셉터 실행! afterCompletion");

    }
}
