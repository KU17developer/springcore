package com.bs.spring.common.interceptor;

import com.bs.spring.common.ViewTemplate;
import com.bs.spring.demo.model.dao.DemoDao;
import com.bs.spring.demo.model.dto.Demo;
import com.bs.spring.demo.model.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("basicinter")
public class BasicInterceptor implements HandlerInterceptor {


    // ctrl + o 단축키 눌러서 추상메소드들 전부 가져오기
    // 인터셉터는 Controller 가기 전 , 실행 후, 실행하고 restreun까지 전부 한 후에 이렇게 메소드로 조건을 줄 수 있음
    // 인터셉터의 장점 : 스프링 컨테이너 안에 있으니깐 @Autowird 해서 데이터를 받을 수도 있음. (필터는 불가능)
    @Autowired
    private DemoService demoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("인터셉터 실행! prehandle");

        // 요청주소 확인하기 ( 어디로 넘어갈때 캐치 했는지 보기 )
        // 파라미터(넘어오는 값이)가 있으면 request로 확인할 수도 있음!
        // 만약 어떤 쿠키값을 저장하고 싶으면 쿠키 생성해서 reponse.addCookie도 이용할 수 있음!
        System.out.println("요청 주소 : " + request.getRequestURI());

//        System.out.println(demoService.selectDemoList()); 이렇게도 사용할 수 있다~

        // 핸들러 라는 Object는 넘어갈때 그 해당하는 controller 클래스가 뭐고 실행되는 메소드가 뭔지 확인할 수 있다!
//        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 오브젝트를 반환 ( 클래스 이름을 알아보자 )
//        System.out.println(handlerMethod.getBean().getClass().getName());

        // 메소드 이름을 알아보자 ( 리플렉스 메소드 반환 )
//        System.out.println(handlerMethod.getMethod().getName());


        // 매개변수에 response가 있기에 return값 false로 해놓고 응답도 줄 수 있음\
        // 이런식으로 차단 시킬수도 있다~
//        request.setAttribute("msg", "못가요!");
//        request.setAttribute("loc", "/");

//        request.getRequestDispatcher("WEB-INF/views/" + ViewTemplate.MESSAGE_VIEW + ".jsp").forward(request, response);

        // true 면넘어가고 false면(페이지가) 안넘어감!
        return true;

    }


    // void 형이기에 따로 반환하는건 없음.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        System.out.println("인터셉터 실행! posthandle");

        // 인터셉터 안에서 정보를 보고 판단해서 내용을 처리하거나 추가하거나 할 수 있다.
        System.out.println(modelAndView);

        // 추가정보를 model에다 저장! msg에서 이 데이터를 쓸 수 있음!
        modelAndView.addObject("msg2", "금요일 마지막시간 파이팅!");
        

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("인터셉터 실행! afterCompletion");

        // 응답하는 페이지(jsp)에서 어떤 에러가 발생하면 exception이 여기로 꽂힘!
        System.out.println(ex);

        // 에러가 발생하면~ 이런식으로 log 남기게 할 수도 있고~ 개발자한테 로그 남기는건 매우매우 중요함!
//        if(ex!=null){
//            service.insertLog();
//        }

    }

}
