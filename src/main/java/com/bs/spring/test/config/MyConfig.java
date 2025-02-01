package com.bs.spring.test.config;

import com.bs.spring.test.model.dto.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration이 있으면 bean 설정파일임. (bean을 등록 할 수 있음) 마치 bean을 등록하던 xml 하고 똑같음.
// 즉 bean을 등록할 수 있는 방법은 3가지임./
// 1. xml파일
// 2. 어노테이션 : Componunt
// 3. Configuration 파일

@Configuration
public class MyConfig {

    @Bean
    public Person p3(){
        return Person.builder()
                .name("김통통")
                .age(33)
                .address("서울시 금천구")
                .build();
    }

}
