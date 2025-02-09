package com.bs.spring.common;


// 애는 굳이 bean을 생성할 필요 없음~
// 만약 이 부분이 ("common/msg") 바뀌면 controller에 가서 일일히 다 바꿔줘야하는데
// 이렇게 선언해놓고 사용하면 common-ViewTemaplte 클래스 가서 바꿔주기만 하면 끝남

public class ViewTemplate {

    public static final String MESSAGE_VIEW = "common/msg";

}
