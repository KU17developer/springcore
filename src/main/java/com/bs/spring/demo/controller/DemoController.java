package com.bs.spring.demo.controller;

import com.bs.spring.demo.model.dto.Address;
import com.bs.spring.demo.model.dto.Demo;
import com.bs.spring.demo.view.MyView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;


// 이 클래스는 스프링 컨테이너가 가지고 실행하는거니깐 @Controller 등록해서 Controller 클래스로 스프링 빈으로 등록!
@Controller
public class DemoController {

    // 단순히 페이지 전환용!
    @RequestMapping("/demo/demo.do")
    public String demo() {
        return "demo/demo";
    }


    // 매핑메소드 파라미터 처리하기 -> 매개변수 활용하기
    // HttpServletRequest, HttpServletResponse 활용하기
    // 서블릿 했던거 처럼 해보기!

    @RequestMapping("/demo/demo1.do")
    public void demo1(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {

        System.out.println(request);
        System.out.println(response);

        String name = request.getParameter("devName");
        int age = Integer.parseInt(request.getParameter("devAge"));
        String gender = request.getParameter("devGender");
        String[] devLang = request.getParameterValues("devLang");

        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(Arrays.toString(devLang));

        // 안하면 한글 깨지니깐 해줘야함!
        response.setContentType("text/plain;charset=utf-8");

        // PrintWriter는 throws IOException 처리 해줘야함!
        PrintWriter out = response.getWriter();
        out.print(name);
        out.print(age);
        out.print(gender);
        out.print(Arrays.toString(devLang));

        Demo d = Demo.builder()
                .devName(name)
                .devAge(age)
                .devGender(gender)
                .devLang(devLang)
                .build();

        request.setAttribute("demo", d);

        // HttpSession 이용하기
        session.setAttribute("loginMember", "admin");



        request.getRequestDispatcher("/WEB-INF/views/demo/demoResult.jsp").forward(request,response);
        // return "";

    }

    // 파라미터값을 매개변수와 매칭하여 받아오기
    // 매개변수 선언할 때 파라미터의 key값과 동일하게 설정
    // devName, devAge, devEmail, devGender, devLang 파라미터를 전송
    // request.getParameter()메소드를 직접 사용하지 않아도됨!
    // 파라미터 데이터가 필수값(required)일때만 활용해 ㅠㅠ
    @RequestMapping("/demo/demo2.do")
    public String demo2(String devName, int devAge, String devEmail, String devGender, String[] devLang, Model model) {

        System.out.println(devName);
        System.out.println(devAge);
        System.out.println(devEmail);
        System.out.println(devGender);
        System.out.println(Arrays.toString(devLang));

        Demo demo = Demo.builder()
                .devAge(devAge)
                .devGender(devGender)
                .devLang(devLang)
                .devName(devName)
                .build();

        // model객체에 저장하기
        // addAttribute()메소드를 이용해서 데이터를 저장
        // key, value 형식으로 저장
        model.addAttribute("demo", demo);



        return "demo/demoResult";

    }

    // 파라미터(클라이언트가 보낸 값)와 연결되는 매개변수 추가 설정하기
    // 이름(명칭)이 다를 때 연결, 기본 값 설정, 필수 값 설정
    // @RequestParam 어노테이션을 이용
    @RequestMapping("/demo/demo3.do")
    public String demo3(
                        @RequestParam(value = "devName") String name,
                        @RequestParam(value = "devAge", defaultValue = "10") int age,
                        @RequestParam(value = "devEmail") String email,
                        @RequestParam(required = false) String devGender,
                        @RequestParam(required = false) String[] devLang,
                        Model model)
                        {

        System.out.println(name);
        System.out.println(age);
        System.out.println(devGender);
        System.out.println(email);
        System.out.println(Arrays.toString(devLang));

        return "demo/demoResult";
    }


    // 파라미터를 DTO로 바로 저장하기
    // 파라미터에 key와 DTO의 필드명이 일치하는 값만 저장 (스프링이 알아서 넣어줌!)
    // 기본적으로 DTO 필드에 다른 클래스가 있으면 저장할 수 없다.
    // 날짜 설정 java.util.Date는 스프링은 파싱을 하지 못함 ㅠㅠ
    // java.sql.Date는 가능함!
    // @ModelAttribute 어노테이션 -> Model에 바로 저장해줌
    @RequestMapping("/demo/demo4.do")
    public String demo4(@ModelAttribute("d") Demo demo, Address address){

        demo.setAddress(address);

        System.out.println(demo);

        return "demo/demoResult";

    }

    // 파라미터를 Map으로 저장하기

    @RequestMapping("demo/demo5.do")
    public String demo5(@RequestParam Map param, String[] devLang, Model model) {

        param.put("devLang", devLang);

        System.out.println(param);

        model.addAttribute("demo", param);

        return "demo/demoResult";
    }

    // 추가 정보 가져오기
    // Session 저장된 값, Cookie값, Header값
    // @SessionAttribute(value="key") -> session
    // @CookieValue(value="key") -> Cookie
    // @RequestHeader(value="key") -> RequestHeader

    @RequestMapping("/demo/demo6.do")
    public String demo6(Demo demo,
                        @SessionAttribute(value = "sessionId", required = false) String id,
                        @CookieValue(value="lunch", required = false) String menu,
                        @RequestHeader(value = "Accept") String accept) {

        System.out.println(id);
        System.out.println(menu);
        System.out.println(accept);

        return "demo/demoResult";
    }

    // 매핑메소드 리턴
    // 기본적으로 String을 리턴 -> ViewResolver가 처리하는 대로 화면을 출력
    // ModelAndView -> Model, view정보를 한번에 저장하는 객체
    @RequestMapping("/demo/demo7.do")
    public ModelAndView demo7(Demo demo, ModelAndView mv){

        // 데이터 저장하기
        mv.addObject("demo", demo);

        // view 설정하기
        mv.setViewName("demo/demoResult");
        ModelAndView mv1 = new ModelAndView("demo/demoResult",
                "demo", demo);

        // view정보 확인하기
        System.out.println(mv1.getViewName());

        // model정보 확인하기
        Map<String, Object> modelDate = mv1.getModel();
        System.out.println(modelDate);

        return mv1;
    }


    // 리턴값으로 객체 설정하기 -> 데이터만 전송
    // @ResponseBody
    // ajax요청처리, RestAPI로 서비스를 구성할 때 사용
    @RequestMapping("/demo/demo8.do")
    @ResponseBody
    public Demo returnObj(){
        return Demo.builder()
                .devName("test")
                .build();
    }

    @RequestMapping("/demo/demo9.do")
    @ResponseBody
    public Demo testObj(@RequestBody Demo demo){
        System.out.println(demo);
        return demo;
    }

    // View구현체로 응답하기

    @RequestMapping("/demo/demo10.do")
    public View myViewTest(MyView view, Model model){

        model.addAttribute("test", "나의 view");

        return new MyView();
    }

}
