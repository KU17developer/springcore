package com.bs.spring.demo.model.dao;

import com.bs.spring.demo.model.dto.Demo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

// 어노테이션(스프링 빈 등록)은 인터페이스가 아니라 여기 impl에다 설정해야함!
// 앞으로 MVC 패턴에 있는 애들은 다 빈으로 등록해놓고 의존성 주입을 받아서 쓴다

@Repository
public class DemoDaoImpl implements DemoDao {

    @Override
    public List<Demo> selectDemoList(SqlSession session) {
        return session.selectList("demo.selectDemoList");
    }

    @Override
    public int insertDemo(SqlSession session, Demo demo) {
        return session.insert("demo.insertdemo", demo);
    }


    @Override
    public int updateDemo(SqlSession session, Demo demo) {
        return 0;
    }

    @Override
    public int deleteDemo(SqlSession session, Demo demo) {
        return 0;
    }

    @Override
    public Demo selectDemoByNo(SqlSession session, int demoNo) {
        return null;
    }
}
