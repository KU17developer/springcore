package com.bs.spring.member.controller;

import com.bs.spring.member.model.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bs.spring.member.model.dto.Member;
import org.springframework.web.bind.support.SessionStatus;

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

// 대괄호 해주고 이렇게 중괄호 안에다 키값을 적어줘야함. ({"loginMember"})
// 중괄호 하는 이유는 session(으로?)에 올릴 값들을 쉼표해서 여러개 선언할 수도있음.
@SessionAttributes({"loginMember"})
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
            return "common/msg";
        }else{
            // 로그인 성공
            // 로그인 성공하면 세션에 저장하고 처리해야 하잖아! 그러니깐 매개변수에  HttpSession session 선언!
            // loginMember는 member를 저장!
            // session.setAttribute("loginMember", member);


            // 위에 session.setAttribute("loginMember", member); 이걸 대체해서 쓸 수 있음
            // model은 기본적으로 request와 같은 생명주기를 가지니깐(리다이렉트해서 요청이 새로 오는 순간 날라감) 단순히 이렇게 적으면 안되고 별도의 작업이 필요함
            // 그 별도의 작업은 model에 저장돼 있는 특정 키를("loginMember") 클래스 선언부 위에다 @SessionAttributes({"loginMember"}) 이렇게 적는것임!
            // 이렇게 하면 request 범위가 아닌 session범위로 올릴수 있다. ("loginMember"의 키값에 대해서만)
            // 이젠 session처럼 유지가 된다!
            model.addAttribute("loginMember", member);

            // 로그인 됐으니깐 메인으로 ! ( 로그인 로직 계속 돌아가면 안되니깐 리다이렉트 )
            return "redirect:/";
        }

    }

    // 로그아웃도 만들어보자!
    // 로그아웃 로직 만들 때 원래 세션에 있는 값을 가지고 했지만 위에서 model을 가지고 권한상승 시켜서 처리를 했기 때문에
    // 매개변수에 SessionStatus라는 spring web에서 제공하는 객체를 사용 (애를 가지고 관리하면 됨)
    // SessionStatus 애는 그냥 의존성 주입 받는거죠. ( 매개변수로 넣었으니 자동으로 의존성 주입 받아지는건가? )
    // 이젠 스프링 안에서는 SessionStatus가 세션을 관리해서 처리!
    @RequestMapping("/logout.do")
    public String logout(SessionStatus status){

        // 만약에 SessionStatus가 완료가 되어있지 않으면 (세션이 아직 살아있으면) 세션을 setComplete(완료시켜라) 해라 즉 세션을 없애라
        if(!status.isComplete()){
            status.setComplete(); // session 삭제하는 메소드
        }
        // 세션 삭제했으니깐 (로그아웃한거니깐) 리다이렉트 해서 메인으로 가면 됨!
        return "redirect:/";
    }


    // 회원가입을 만들어보자!
    // 어차피 Get으로 요청할거니깐 GetMapping을 사용해보자!
    // 단순 페이지 이동이니 아래와 같은 방식으로 바꿀 수 있다!
//    @GetMapping("/enrollmember.do")
//    public String enrollmemberPage() {
//        return "member/enrollMember";
//    }

    // 데이터 받는것도 없는 그냥 일반적인 페이지 연결
    // 그럴때는 이렇게 쓸 수도 있다.
    // 조건 /member/enrollmember.do -> /WEB-INF/views/member/enrollmember.jsp
    // 여기서 /member/enrollmember(매핑주소) 이부분하고 화면을 반환하는 값인 /member/enrollmember(jsp경로) 이 부분하고 일치하면
    // 이렇게 쓰는것도 가능함
    // 이렇게 쓸 때 타입은 void로 해놓고, 당연히 단순 페이지 이동이라 아무것도 받을게 없으니깐 마직막에는 (){} 이렇게 작성.
    // 이런식으로 아무것도 응답이 없을때 메핑주소, 앞에 있는 서버 주소랑 컨텍스트 주소 빼고 확장자도 뺀 다음 그거를 반환해서 페이지 이동시킴.
    // view jsp 경로와 파일명이 매핑주소(확장자를 뺀 나머지 매핑주소)와 내가 찾아가는 view 주소가 같을 때는 이렇게만 쓰고 끝낼 수 있다.
//    @GetMapping("/enroll/member.do")
//    public void enrollmember(){}


    // 회원가입을 만들어보자!
    // 저장은 Post로 받으니깐 이렇게 해도되지! @PostMapping
    @PostMapping("/enrollmemberend.do")
    public String enrollmemberend(Member inputMember, Model model) {    // Model 저장 실패하거나 성공할떄 메세지 출력할려고 사용!

        // MyBatis에서 DML(INSERT, UPDATE, DELETE) 문을 실행한 결과는 int 값으로 반환됩니다.
        int result = service.saveMember(inputMember);

        String msg, loc, viewName = "common/msg";
        if(result > 0) {

//            msg = "회원가입성공";
//            loc = "/";

            // 만약 굳이 메세지를 출력하고 싶지 않다면 이런식으로!
//            return "redirect:/";

            // 이런식으로 해도 되고.. return "redirect:/"; 이거랑 똑같은거임 어차피 지금 밑에서 viewName으로 리턴해주고 있으니깐!
              viewName = "redirect:/";
        }else{
            msg = "회원가입실패";

            // 다시 회원가입 페이지로!
            loc = "/member/enrollmember.do";
            model.addAttribute("msg", msg);
            model.addAttribute("loc", loc);
        }

        return viewName;

    }

}
