package com.bs.spring.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// WEB MVC에 대한 환경설정 할 수 있는 클래스를 만들수 있는데..
// 단순히 페이지만 전환시키는 메소드들은 여기에 모아놓고 관리 할 수 있다.

@Configuration

// 밑에 메소드를 커스텀마이징해서 적용하겠다!
@EnableWebMvc
public class MyWebAppConfig implements WebMvcConfigurer {

    // jsp 환면으로 전환해주는 기능
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 단순히 화면 연결시키는(페이지 전환) 메소드들은 컨트롤러에 적지말고 여기에다 적을 수 있다.
        // 이렇게 해서 컨트롤러는 단순연결을 제외하고 로직처리에 대한 메소드들만 모아둘 수 있음
        // setViewName("member/enrollmember.jsp") 여기에 view resolver가 알아서 찾아감!
        // 컨트롤러에 만들지 않아도 이젠 연결된다!
        // 뷰나 리액트 할때는 무용지물이다. ( 뷰, 리액트, 서버 다 각각 돌기 때문에)
        registry.addViewController("/member/enrollmember.do").setViewName("member/enrollmember.jsp");
    }
}
