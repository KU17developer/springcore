package com.bs.spring.test.controller;

import com.bs.spring.test.model.dto.Animal;
import com.bs.spring.test.model.dto.Person;
import com.bs.spring.test.model.dto.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Scanner;

@Controller
public class TestController {

    // 의존성 등록하기
    // spring bean으로 등록된 객체를 가져와 사용
    // @Autowired 어노테이션을 이용해서 선언
    // 의존성 등록 할때 기준이 되는건 필드값하고 매개변수만 설정이 가능
    // 필드값만!! , 메소드 내부에 선언되는 지역변수들은 불가능하다라는 뜻임!


    // @Autowired는 첫번째는 타입을 보고, 두번째는 변수명과 일치하는 ID값이 있는지 찾음.
    // 변수명과 id가 일치하지 않으면 타입보고 가져오는듯???..
    // 최대 1개씩만 생성하는게 좋은듯..? 지금 animal은 anima11, 2, 3 3개 있잖아
    // ID랑 필드명 항상 맞춰서 만드는건 힘드니깐 @Qualifier를 이용해서(id값을 지정해) 특정 빈을 선택해서 주입하게 만들 수 있다.

    @Autowired
    @Qualifier("animal2")
    private Animal a;

    @Autowired
    @Qualifier("person")
    private Person p;

    // spring bean으로 등록되지 않은 클래스를
    // @Autowired 선언하면 에러가 발생! ( NoSuchBeanDefinitionException )
    // @Autowired 어노테이션 옵션 설정하기 ( required )
    // @Autowired는 필수값 -> 무조건 넣어! 없으면 에러!

    @Autowired(required=true)  // false == 있으면 넣고 없으면 넣지(에러 발생시키지)마.
    private Scanner sc;

    @Autowired
    private Temp t;


    // spring이 (제공해주는)생성한 객체 가져오기
    @Autowired
    private WebApplicationContext wc;


    // bean으로 등록된 모든 animal을 가져와서 list로 만들어줌 ㄷㄷ..(타입을 기준으로)
    @Autowired
    List<Animal> animals;


    @RequestMapping("/test/beantest")
    public void testbean() {
        System.out.println("testbean실행");
        System.out.println(a);
        System.out.println(p);
        t.printData();

        // webapplicationcontext 이용
        // 등록된 bean을 가져와서 사용해보자
        System.out.println("==== 설정된 bean 가져오기 ====");
        for(String name : wc.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        System.out.println("list로 객체 가져오기");
        animals.forEach(System.out::println);

    }

}
