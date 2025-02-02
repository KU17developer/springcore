package com.bs.spring.demo.model.dao;

import com.bs.spring.demo.model.dto.Demo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 예전이랑 다 똑같은데 애는 session을 받아서 처리함.
// 스프링와서 service랑 dao랑 가르는 개념이 좀 모호해진거임.

public interface DemoDao {

    List<Demo> selectDemoList(SqlSession session);
    int insertDemo(SqlSession session, Demo demo);
    int updateDemo(SqlSession session, Demo demo);
    int deleteDemo(SqlSession session, Demo demo);
    Demo selectDemoByNo(SqlSession session, int demoNo);

}
