package com.bs.spring.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration  // == spring bean configuration.xml과 동일한 설정 ( 즉 스프링 빈을 설정하는 클래스가 되는 거임! )
public class BeanConfigTest {

    // Bean을 등록하기. (메소드로 등록함)


    /*  <bean id = "scanner" class = "java.util.Scanner> 이렇게 생성한거랑 똑같음.
        <constructor-org index=0  ref = "System.in"/>      */
    @Bean("sc")
    public Scanner scanner() {
        return new Scanner(System.in);
    }









}
