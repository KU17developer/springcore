package com.bs.spring.test.model.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 어노테이션 방식으로 클래스를 spring bean으로 등록
@Component("t")
public class Temp {

    private Person p;
    private Animal a;

    // 매개변수 있는 생성자 선언
    // 생성자로 의존성 주입을 받기

//    @Autowired 생략해도 무방하다.
    public Temp(@Autowired @Qualifier("person1") Person p,
                @Autowired @Qualifier("animal2") Animal a) {
        this.p = p;
        this.a = a;
    }

    public void printData(){
        System.out.println("Person" + p);
        System.out.println("Animal" + a);
    }

}
