package com.bs.spring.demo.controller;

import com.bs.spring.demo.model.dto.Demo;
import com.bs.spring.demo.model.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor

@Controller
// Controller 아래에다가도 @RequestMapping 이렇게 설정할 수 있음.
// 클래스에다 이렇게 주소를 설정하는건 이 전체 매핑 메소드에 제일 앞에 붙는 (시작)주소가 되는거임. (아주 유용!!)
@RequestMapping("/demo")
public class DemoController2 {

    // DemoController2는 DemoService에 의존한다.
    // 애도 마찬가지로 필드가 1개니깐 @Autowired 없이 위에 @AllArgsConstructor 해주면 의존성 주입까지 해줌!
    // 왜냐하면 @AllArgsConstructor 이렇게 하면 생성자가 한개밖에 없을테니깐.
    // 가독성도 떨어지고.. 그래도 지금 배우는중이니깐 일일히 @Autowired 써보자! (권장되지는 않음)
    //@Autowired
    private DemoService demoService;

    // 그리고 위에보다는 생성자를 통해서 주입하는걸 스프링에서는 더 권장한다.. 가독성도 굿
    @Autowired
    public DemoController2(DemoService demoService) {
        this.demoService = demoService;
    }



    // 요청을 매핑하는 어노테이션
    // RequestMapping : 전체에 대한 요청에 대한걸 매핑할때 사용

    // 요청 메소드에 따른 매핑 어노테이션
    // @GetMapping
    // @PostMapping
    // @PutMapping
    // @PatchMapping
    // @DeleteMapping

    // @RequsetMapping(value="url", params="파라미터에 대한 설정", headers="", consumes="', produces="", method="")
    // 이런 속성(옵션값)들로 요청받는 것들을 필터링 할 수가 있음.
    // @GetMapping 등 다른곳에서도 사용가능한듯?

    @RequestMapping(
                    // url 매핑
                    value="/request/test",
                    // 이 요청은 GET방식만 받겠다. ( 만약 POST 방식으로 보내게 되면 405 에러 발생. ) RequestMethod.POST 등 다양하게 사용가능.
                    method = RequestMethod.GET,
                    // params : 파라미터 값에 대한 옵션을 설정 할 수 있다. (파라미터는 키 벨류 형식으로 넘어옴) (headers도 비슷함 이렇게 옵션 부여 가능)
                    // 즉 어떠한 값들은 있어야하고 어떠한 값들은 없어도 되고 이런것들을 @RequestMapping 안에다 옵션을 줘서 파라미터값에 대한 설정을 할 수 있다.
                    // 옵션값이기에 꼭 쓸 필요는 없고 설정해야될 필요가 있을때만 사용하면 된다.
                    // "accesskey" :  파라미터로 넘어오는 값들 중에 accesskey가 있어야지만 이 메소드를 실행하겠다!
                    // 필요한 값이 다수면 중괄호해서(배열방식으로) , 넣어서 계속 쓰면됨
                    // test=유병승 : test는 반드시 유병승값이 넘어와야해
                    // !data : data라는 파라미터 키값을 가지면 안된다.
                    // !가 있으면 이 파라미터는 넘어오면 안됨.
                    params = {"accesskey", "test=유병승", "!data"},
                    // consumes : 별도로 contenttype에 대한 내용임
                    // application/json : application/json으로만 받을거야!
                    // 그냥 보내면 media타입이  "application/xwww" 타입인듯?
                    consumes = "application/json"
                    )
    public String test() {
        System.out.println("test메소드 실행");
        return "/";
    }


    // 요청 메소드에 따른 매핑 어노테이션
    // @GetMapping == 이거랑 그냥 똑같은거임... 좀 간추려서 쓸 수 있다느거 뿐 (@RequestMapping(value = "주소", Method=RequestMethod.GET))
    // POST방식으로 넘어오면 안받음.
    // @GetMapping(value = "/test2") 여기에서도 다양한 옵션을 줄 수가 있음. value, param 등 (위에서 했던것들)
    @GetMapping(value = "/test2")
    public String test2() {

        System.out.println("test2 실행");

        // redirect: : sendRedirect로 전환 (입력 수정 삭제 로그인 했을 때 주로 사용)
        return "redirect:/";
    }


    // @PostMapping
    // POST 요청만 받겠다!
    @PostMapping(value="/test3")
    public String test3() {
        System.out.println("test3 실행");

        return "redirect:/";
    }

    // @PutMapping
    // @PatchMapping
    // @DeleteMapping

    @RequestMapping("/insertdemo.do")
    public String insertdemo(@ModelAttribute Demo demo) {

        // DB mybatis
        // 1. mybatis.jar 파일 가져오기
        // 2. mybatis 설정파일 필요 (mybatis-config, mapper.xml)
        // 3. 위에 파일을 가져다 사용하는 SqlSession이 필요! ( SqlSession 안에는 DataSource라는 객체가 필요! )

        int result = demoService.insertDemo(demo);
        System.out.println(result);
        if (result > 0) {}
        else{}
        // 입력구문이니깐 메인으로 이동하게 만들자!
        // 여기서 redirect를 이용하는걸 prg패턴(post로 요청한걸 get으로 다시 재요청하도록 만드는)이라고도 한다.
        return "redirect:/";
    }

}
