package com.bs.spring.memo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

// @Data의 역할 : 기본 생성자, 세터 게터, 투스트링, 해쉬코드, 이퀄스까지 만들어줌.
// 생성자같은 경우는 빈 등록해서 스프링이 알아서 다 만들어주니 나머지는 굳이 필요없긴함.
// 생성자 안에 매개변수로 넣으면 주입도 해주니깐. 근데 원래 이 4개 다 써줬으니깐 그냥 써주자!
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Memo {

    private int memoNo;
    private String memo;
    private String password;
    private Date memoDate;

}
