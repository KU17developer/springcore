package com.bs.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class DemoController2 {

    // 요청을 매핑하는 어노테이션
    // @RequsetMapping(value="url", params="",headers="", consumes="', produces="", method="")
    // params에 !가 있으면 이 파라미터는 넘어오면 안됨.
    @RequestMapping(value="/request/test", method = RequestMethod.GET, params = {"accesskey", "test=유병승", "!data"},consumes = "application/json")
    public String test() {
        System.out.println("test메소드 실행");
        return "/";
    }

    // 요청 메소드에 따른 매핑 어노테이션

    // @GetMapping == @RequestMappin(value = "", Method=RequestMethod.GET)
    @GetMapping("/test2")
    public String test2() {

        System.out.println("test2 실행");
        // sendRedirect로 전환
        return "redirect:/";
    }
    // @PostMapping
    // @PutMapping
    // @PatchMapping
    // @DeleteMapping
}
