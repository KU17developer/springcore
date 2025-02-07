package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;

// 인터페이스를 중간에 넣어서 인터페이스에 의존하고 있으니깐 실질적으로 구현객체는 내가 뭘로 바꾸던 상관없다는거임
// 어차피 메소드는 정해져 있으니깐 그러면 의존하는 객체를 손 대지 않아도.., 왜? 인터페이스가 바뀔일을 없으니깐! 그래서 그렇게 의존을 시켜넣는거임
public interface MemberDao {

    Member findMemberById(SqlSession session, String id);

    int saveMember(SqlSession session, Member member);

}
