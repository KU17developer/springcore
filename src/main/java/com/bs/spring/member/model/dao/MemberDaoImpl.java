package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Override
    public Member findMemberById(SqlSession session, String id) {
        // id 값을 기준으로 Member라는 데이터를 가져오는걸 만들겠다!
        return session.selectOne("member.findMemberById", id);
    }

    @Override
    public int saveMember(SqlSession session, Member member) {
        return session.insert("member.saveMember", member);
    }

}
