package com.bs.spring.demo.model.service;

// DemoService에 대한 인터페이스를 구현한 구현체! 그래서 클래스명 뒤에 impl 붙여서 만듦.

import com.bs.spring.demo.model.dto.Demo;

import java.util.List;

public class DemoServiceimpl implements DemoService {

    @Override
    public List<Demo> selectDemoList() {
        return List.of();
    }

    @Override
    public int insertDemo(Demo demo) {
        return 0;
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
