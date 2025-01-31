package com.bs.spring.test.model.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 어노테이션 방식으로 클래스를 spring bean으로 등록
// bean을 xml로도 등록할 수 있고 이런식으로 어노테이션으로도 등록할 수 있음!
// 등록한 빈을 @Qualifier를 이용해서 id를 매칭해 주입할 수 있는데 Componunut 어노테이션으로 등록한 건 이름이 없기에 클래스명이 (소문자) id가됨
// 근데 그 이름말고 내가 이름을 정하고 싶으면 @Component("t") 이런식으로 이름을 정할 수 있음.

@Component("t")
public class Temp {

    private Person p;
    private Animal a;

    // 매개변수 있는 생성자 선언
    // 생성자로 의존성 주입을 받기
    // 매개변수로 의존성 주입을 받을 때는 @Autowired 생략해도 무방하다.
    // @Autowired   매개변수에 있는 @Autowired 빼고 이렇게 생성자 위에 써도 되고 근데 생략해도 무방.
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
