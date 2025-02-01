package com.bs.spring.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

// @Configuration이 있으면 bean 설정파일임. (bean을 등록 할 수 있음) 마치 bean을 등록하던 xml 하고 똑같음.
// 즉 bean을 등록할 수 있는 방법은 3가지임./
// 1. xml파일
// 2. 어노테이션 : Componunt
// 3. Configuration 파일

@Configuration  // == spring bean configuration.xml(파일)과 동일한 설정 ( 즉 스프링 빈을 설정하는 클래스가 되는 거임! )
public class BeanConfigTest {

    // Bean을 등록하기. (메소드 방식으로 bean을 등록함)


    /*  <bean id = "scanner" class = "java.util.Scanner> 이렇게 생성한거랑 똑같음.
        <constructor-arg index=0  ref = "System.in"/>      */

    // 기본적으로 변수명이 bean id가 되는거지만 마음에 안들면 @Bean("sc") 이런식으로 이름을 지정해 줄 수도 있음.
    @Bean("sc")
    public Scanner scanner() {
        return new Scanner(System.in);
    }






}
