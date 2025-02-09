package com.bs.spring.memo.model.dao;

import com.bs.spring.memo.model.dto.Memo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MemoDao {

    List<Memo> findMemo(SqlSession session);


    int saveMemo(SqlSession session, Memo memo);

}
