package com.bs.spring.member.controller;

import com.bs.spring.member.model.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bs.spring.member.model.dto.Member;

import javax.servlet.http.HttpSession;

// private MemberService service; 애 의존성 주입받기 위해!
// 그러면 애는 생성자가  필드로 갖고 있는 전체 매개변수를 가지고 생성을 한다.
// 그러면 이 객체(private MemberService service;?)는 컨트롤러로 스프링 빈을 등록했으니깐 스프링이 생성함. 그러면 애는 무조건 매개변수 있는 생성자를 써야함.
// 그래서 컨텍스트에서 빈 등록할 때 보여주셨던거임! (디폴트 생성자 없으면 에러났던거)
// 빈을 등록 안한 필드까지 의존성 주입을 시켜버릴 수 있기에 @RequiredArgsConstructor를 쓰는 경우도 많다.
//@AllArgsConstructor (주입 어노테이션)


// 애는 final로 선언된 필드를 매개변수로 선언하는 생성자
// 필수로 의존성 받는것만 final로 선언해놓고 @RequiredArgsConstructor 씀.
// @AllArgsConstructor 이거는 필드 전부를 생성해버리니깐 구분하기 위해 @RequiredArgsConstructor 이걸 쓰기도 한다.
//@RequiredArgsConstructor (주입 어노테이션)


// 나 이거 컨트롤러 만들었어! 스프링한테 알려주기! 스프링 빈 등록!
@Controller
@RequestMapping("/member")
public class MemberController {

    // 인터페이스의 장점! 구현체가 없더라도 컨트롤러는 완성시킬수가 있음! MemberService를 인터페이스 타입으로 일단 선언시켜놓으면 되니깐!
    // 즉 안에 구현체가 완성되지 않았더라도 인터페이스를 일단 만들어 놓았기에 이걸 타입으로 쓸 수 있는거임!
    private final MemberService service;

    // 이렇게 쓰는것도 가능. private final MemberService service; 이거 선언하고 alt + insert 하면된다! ( 이렇게 생성자 선언하면 주입 받음 )
    // 이렇게 하면 @RequiredArgsConstructor, @AllArgsConstructor 이것을 한거나 마찬가지니깐 이런 어노테이션 선언할 필요가 없어짐.
    // 내가 편한걸 쓰면 된다!
    // MemberService는 인터페이스 타입이니깐 주입할려할때 애에 대한 "구현체!!"를 찾으려함! 그래서 MemberServiceImpl 까지 만들어서 그것도 빈으로 등록해줘야 정상 작동!
    public MemberController(MemberService service) {
        this.service = service;
    }


// 요청을 받는 매핑메소드를 만들자!

    @RequestMapping("/login.do")
    // 매개변수로 넘어오는 키값(name) 이랑 필드명 맞춰주기!
    // 메세지 띄워줄려면 데이터 저장소인 model이 필요함!
    public String login(String userId, String pw, Model model, HttpSession session) {

        // 찾은 member를 가져오자
        Member member = service.selectmemberById(userId);

        // member가 null이거나 패스워드가 일치하지 않으면 로그인 실패!
        if(member == null || !member.getPassword().equals(pw)) {
            // 로그인 실패
            model.addAttribute("msg", "아이디와 패스워드가 일치하지 않습니다.");
            // "/" 이거는 메인페이지로 이동.
            model.addAttribute("loc", "/");
        }else{
            // 로그인 성공
            // 로그인 성공하면 세션에 저장하고 처리해야 하잖아! 그러니깐 매개변수에  HttpSession session 선언!
            // loginMember는 member를 저장!
            session.setAttribute("loginMember", member);
            
        }
        return "";

    }

}
