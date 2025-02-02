package com.bs.spring.demo.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

// View 역할을 할거임!
// 응답하는걸 내가 만들어서 처리할거야!(커스텀마이징)
@Component
public class MyView implements View {

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println(model);

        // plain은 형식이 없는 일반적인 문구, 그냥 문자들 응답할때 쓰임.
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("내가 만든 응답이야!");
    }
}
