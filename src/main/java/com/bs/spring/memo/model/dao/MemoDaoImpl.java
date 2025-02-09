package com.bs.spring.memo.model.dao;

import com.bs.spring.memo.model.dto.Memo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MemoDaoImpl implements MemoDao {

    @Override
    public List<Memo> findMemo(SqlSession session) {

        return session.selectList("memo.selectMemo");

    }

    @Override
    public int saveMemo(SqlSession session, Memo memo) {

        return session.insert("memo.insertMemo", memo);

    }

}
