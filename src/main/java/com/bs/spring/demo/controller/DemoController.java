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
    // 필요한게 있으면 매개변수에 선언하면 스프링 컨테이너가 알아서 그 객체에 해당하는 타입에 의존성 주입을 다 해줌! 그러니깐 session도 매개변수에 넣어서 바로 쓸 수 있는거!
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
    // 그래서 내가 이 이름과 똑같이만 설정해주면 스프링이 알아서 데이터를 매개변수에 넣어줌! (키값만 매칭만 시키면)
    // request.getParameter()메소드를 직접 사용하지 않아도됨!
    // 명심!!  이렇게 직접 매칭해서 줄때는 기준이 반드시 보내주는 파라미터 키값과 매개변수 변수명이 일치하는 것만 값을 넣어줌!
    // 그리고 형변환도 매개변수에 타입에 맞게 int나 배열로 알아서 형변환 해줌 ( 원래는 무조건 string 반환이었잖아. )
    // 마지막으로 매개변수에 request 했었으면 request.setattribute이런식으로 담아서 보낼 수 있는데 여긴 없잖아. 그래서 Model을 사용하는거임!(model은 request와 생명주기는 같음)


    // 파라미터 데이터가 필수값(required)일때만 활용해 ㅠㅠ
    // 왜냐하면 매개변수가 string인건 괜찮지만 int나 double형인 타입에 대해서 null이 들어오면 형변환중에 에러가 발생함..(null을 숫자로 형변환 할 수가 없으니)
    // 그래서 통상 이렇게 1:1로 매칭해서 어떠한 데이터를 받을때는 진짜로 넘어오는 필수값일때만 사용.
    // 하지만 아래에서 값이 들어오지 않아도 사용할 수 있는 방안(예시가) 있음! public String demo3 메소드 ! (@RequestParam 이용!)
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

        // 화면에 공유하기위해서 (jsp로 데이터를 보내기 위해) model객체에 저장하기
        // addAttribute()메소드를 이용해서 데이터를 저장
        // key, value 형식으로 저장
        model.addAttribute("demo", demo);


        return "demo/demoResult";

    }


    // 파라미터(클라이언트가 보낸 값)와 연결되는 매개변수 추가 설정하기
    // 이름(명칭)이 다를 때 연결, 기본 값 설정, 필수 값 설정
    // @RequestParam 어노테이션을 이용하여 추가적인 속성을 통해서 처리할 수 있다!!
    @RequestMapping("/demo/demo3.do")
    public String demo3(
                        // @RequestParam(value = "")을 써주면 이렇게 필드명이 달라도 연결할 수 가 있는거임!!
                        @RequestParam(value = "devName") String name,
                        // @RequestParam(defaultValue = "10") 이렇게 기본값을 설정해주면 클라이언트가 값을 입력안해도 기본값으로 데이터를 넣고 페이지가 정상적으로 돌아감!!
                        @RequestParam(value = "devAge", defaultValue = "10") int age,
                        @RequestParam(value = "devEmail") String email,
                        // 원래 매개변수에 넣는 값들은 다 필수로 들어와야하는 값이지만 @RequestParam(required = false) 이걸 이용하면 있으면 가져오고 없으면 안가져와도 돼! 이런뜻임!
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


    // 어차피 객체로 만들거 파라미터를 DTO로 바로 저장하자!! ( 애를 커맨드라고 이야기함 )
    // 조건 : 파라미터에 key와 DTO의 필드명이 일치하는 값만 저장 (너무 중요!!!) (스프링이 알아서 객체 만들어서 넣어줌!)
    // 명심할점 : 기본적으로 DTO 필드에 다른 클래스가 있으면 저장할 수 없다. ( 모든 자료형을 다 처리할 수는 없다. (추가적인 설정을 하면 되긴 하는듯? .이런거 이용해서.. 하지만 굳이..) )
    // 커맨드 객체로 받을 때 날짜 설정 (예를 들어 생년월일같은 데이터 받을때..) java.util.Date는 스프링은 파싱을 하지 못함 ㅠㅠ.. 오류가 발생한다.. (init binder 같은거 쓰면 되긴함 나중에 찾아보고 사용해보기)
    // java.sql.Date는 가능함!
    // @ModelAttribute 어노테이션 -> Model에 바로 저장해줌
    @RequestMapping("/demo/demo4.do")
    public String demo4(
                        // @ModelAttribute 어노테이션을 선언하면 데이터 받은 다음에 변수명(key값)으로 attribute로 저장을 시켜줌. ("d") 이런식으로 이름(key값)을 지정해서 저장할 수도 있음.!
                        // 아마 model.addAttribute("demo", demo); 이런 부분까지 생략해주는 좋은 어노테이션 인것 같다..
                        @ModelAttribute("d") Demo demo,
                        // 이런식으로 들어오는 값들 객체들 다 선언해놓고 키값과 안에 필드만 일치하면 다 집어넣어준다. 객체가 따로따로 분리돼있을때 이렇게도 값을 받을수 있는거임!
                        // Demo 클래스 안에 Address 타입 필드가 있으니 System.out.println(demo); 이렇게 출력하면 한번에 다같이 출력됨! 즉 Demo 클래스 안에 Address에 값이 들어오는거다!
                        Address address){

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
