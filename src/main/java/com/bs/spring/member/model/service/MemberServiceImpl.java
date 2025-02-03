package com.bs.spring.member.model.service;

// MemberService가 갖고있는 추상메소드들을 재정의 해줘야한다!

import com.bs.spring.member.model.dao.MemberDao;
import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

// @Service를 사용해서 빈으로 등록!
@Service
public class MemberServiceImpl implements MemberService {

    // 애는 MemberDao 한테 의존하잖아!
    private MemberDao dao;

    // 그리고 SqlSession 을 관리하니깐 애도 의존성 주입을 받아야지!
    // 애를 여기다 넣은 이유는 생성주기 관리할려고! 이걸 dao에 넣는경우도 있음(회사마다 다르다)..
    private SqlSession session;


    @Override
    public Member selectmemberById(String id) {
        // MemberDao 인터페이스에 있는 findMemberById 추상메소드 
        return dao.findMemberById(session, id);
    }

}
