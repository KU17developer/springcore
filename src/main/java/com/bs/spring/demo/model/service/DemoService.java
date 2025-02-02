package com.bs.spring.demo.model.service;

import com.bs.spring.demo.model.dto.Demo;

import java.util.List;


// spring은 (웹MVC에서?) 인터페이스를 중간에 넣는 패턴을 사용한다. 어떤 기능에 의존할 때 직접 그 스프링 빈에 의존하는게 아니라 인터페이스 타입에 의존하고
// 그 구현체를 주입받아서 쓰는 패턴을 유지한다. 그래야 트랜잭션 처리나 프록시 객체를 넣어서 중간에 뭔가 개입해서 처리하는 로직들을 만들 수 있다.

// 예전까지는 클래스와 클래스가 직접 연결돼서 강결합 상태를 유지했다면 이제는 모듈화를 위해 중간에 인터페이스를 집어넣으면서 객체간의 결합도를 떨어트린다.
// 스프링은 인터페이스를 가지고 이런식으로 설계를 한다.


public interface DemoService {

    // 인터페이스니깐 그냥 추상메소드 선언한거임! (인터페이스니깐 당연히 이 메소드들을 실행할 수 없음. DemoServiceimpl 클래스를 만들어서 사용하자)
    List<Demo> selectDemoList();

    int insertDemo(Demo demo);

    int updateDemo(Demo demo);

    int deleteDemo(Demo demo);

    Demo selectDemoByNo(int demoNo);

}
