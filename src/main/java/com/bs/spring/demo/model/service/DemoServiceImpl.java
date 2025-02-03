package com.bs.spring.demo.model.service;

// DemoService에 대한 인터페이스를 구현한 구현체! 그래서 클래스명 뒤에 impl 붙여서 만듦.

import com.bs.spring.demo.model.dao.DemoDao;
import com.bs.spring.demo.model.dto.Demo;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DemoService를 구현체로 넣어주가!
// 그리고 ctrl+o하면 재정의 할 추상메소드를 가져올 수 있음.

// 어노테이션(스프링 빈 등록)은 인터페이스가 아니라 여기 impl에다 설정해야함!
// 앞으로 MVC 패턴에 있는 애들은 다 빈으로 등록해놓고 의존성 주입을 받아서 쓴다

// 애 쓰면 밑에 sqlSession과 demoDao위에 @Autowired 안써줘도 되는데 그래도 일일히 위에 @Autowired 써주는게 추천됨.
@AllArgsConstructor


@Service
public class DemoServiceImpl implements DemoService {


    // Service에서는 session과 dao를 의존
    // 타입을 인터페이스 타입으로 줬음. 객체를 특정하지 않았다는 뜻임. 그럼 훨씬 더 서비스 자체가 유연해짐
    // 왜냐하면 구현체중에 아무나 접속해서 쓸 수 있으니깐.. 그래서 애를 인터페이스 타입으로 선언해서 쓰는거임
    // 객체간의 결합도를 떨어트려서 이 객체가 아무리 바껴도 애는 그냥 그 상태로 유지될수 있게.

    // 구현체들이 다 들어옴.
    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private DemoDao demoDao;


    // 위에 생략하고 이런식으로 쓸수도 있긴함.
//    public DemoServiceImpl(SqlSession sqlSession, DemoDao demoDao) {
//        this.sqlSession = sqlSession;
//        this.demoDao = demoDao;
//    }


    @Override
    public List<Demo> selectDemoList() {
        return null;
    }

    @Override
    public int insertDemo(Demo demo) {
        return demoDao.insertDemo(sqlSession, demo);
    }

    @Override
    public int updateDemo(Demo demo) {
        return 0;
    }

    @Override
    public int deleteDemo(Demo demo) {
        return 0;
    }

    @Override
    public Demo selectDemoByNo(int demoNo) {
        return null;
    }
}
