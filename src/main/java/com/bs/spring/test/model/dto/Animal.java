package com.bs.spring.test.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Animal {

    private String name;
    private int age;
    private String gender;
    private double weight;

//    Alt + insert 단축키를 사용하면 생성자 쉽게 만들 수 있음!

//    public Animal() {}
//
//    public Animal(String name, int age, String gender, double weight) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.weight = weight;
//    }
//
//    public Animal(String name) {
//        this.name = name;
//    }
//
//    peroperty 쓰기 위해서 setter 선언!
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public void initTest(){
        System.out.println(this.name+this.age+this.gender+this.weight);
    }

    public void destroyTest(){
        System.out.println("객체 소멸됨!");
        System.out.println(this.name+this.age+this.gender+this.weight);
    }
}

