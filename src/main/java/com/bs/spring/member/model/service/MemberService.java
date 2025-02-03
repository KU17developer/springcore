package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Member;

// 인터페이스를 중간에 넣어서 인터페이스에 의존하고 있으니깐 실질적으로 구현객체는 내가 뭘로 바꾸던 상관없다는거임
// 어차피 메소드는 정해져 있으니깐 그러면 의존하는 객체를 손 대지 않아도, 왜? 인터페이스가 바뀔일을 없으니깐! 그래서 그렇게 의존을 시켜넣는거임
public interface MemberService {

    // Member를 반환하는 selectmemberById로 가져오는! 애는 서비스니깐 String id 받으면 됨!
    // 회원 찾았을 때 Member 가져와서 전부 확인해야 하니깐! 그래서 String id로 가져오는거로 했음!
    Member selectmemberById(String id);

}
