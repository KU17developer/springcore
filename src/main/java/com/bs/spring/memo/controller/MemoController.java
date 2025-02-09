package com.bs.spring.memo.controller;

import com.bs.spring.common.ViewTemplate;
import com.bs.spring.memo.model.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bs.spring.memo.model.dto.Memo;

import java.util.List;

@Controller
@RequestMapping("/memo")
public class MemoController {


    // 서비스에 의존 (의존성 주입)
    // 인터페이스 하고 구현체까지 만들어 줘야 의존성 주입이 된다는거 잊지말기!
    private MemoService memoService;

    // 서비스에 의존 (의존성 주입)
    // 인터페이스 하고 구현체까지 만들어 줘야 의존성 주입이 된다는거 잊지말기!
    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }


    // model에 담아서 메모리스트를 화면에 뿌려줄거임!
    @RequestMapping("/memolist.do")
    public String memolist(Model model) {

        // DB에 저장된 memo 데이터를 가져오기
        List<Memo> memos = memoService.findMemo();

        // 가져온 데이터(메모리스트)를 model에 저장
        model.addAttribute("memos", memos);

        // model에 저장된 데이터와 함께 memo/memoList jsp로 보냄!
        return "memo/memoList";
    }


    // 메모 저장
    @PostMapping("/savememo.do")
    public String savememo(Model m, Memo memo, BCryptPasswordEncoder passwordEncoder) {

        String encPw = passwordEncoder.encode(memo.getPassword());
        memo.setPassword(encPw);
        int result = memoService.saveMemo(memo);

        if(result>0){
            // 저장이 되면 메모리스트 화면으로!
            // 우리가 항상 컨트롤러에 요청 할때 redirect로 요청하면됨!
            // "/memo/memolist.do" 이렇게만(문자열로 반환하면) 쓰면 앞 뒤에 프리픽스 서픽스를 뷰리졸버가 붙여버림.
            return "redirect:/memo/memolist.do";

        } else{

            m.addAttribute("msg", "메모 등록 실패");
            m.addAttribute("loc", "/memo/memolist.do");

            // 이젠 이렇게 안쓰고
            // 만약 이 부분이 ("common/msg") 바뀌면 controller에 가서 일일히 다 바꿔줘야하는데
            // 이렇게 선언해놓고 사용하면 common-ViewTemaplte 클래스 가서 바꿔주기만 하면 끝남 ( 유지보수가 편해짐 )
            // 이런식으로 공통적으로 사용하는 것들에 대해서는 이렇게 사용하는게 좋다.
            // return "common/msg";

            return ViewTemplate.MESSAGE_VIEW;

        }
    }
}
