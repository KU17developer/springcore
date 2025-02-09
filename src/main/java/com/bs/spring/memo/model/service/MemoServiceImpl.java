package com.bs.spring.memo.model.service;

import com.bs.spring.memo.model.dao.MemoDao;
import com.bs.spring.memo.model.dto.Memo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

// 스프링 빈 등록! 그래야 가져다 쓸 수 있지!
// 구현체에다 @Service 이렇게 등록하는거지. 인터페이스에다 @Service 이거 쓰는거 아님!
@Service
public class MemoServiceImpl implements MemoService {

    // Service는 Dao에 의존!
    private MemoDao memoDao;

    // Service는 SqlSession을 의존!
    private SqlSession session;


    public MemoServiceImpl(MemoDao memoDao, SqlSession session) {
        this.memoDao = memoDao;
        this.session = session;
    }

    @Override
    public List<Memo> findMemo() {

        // session을 보내면서 호출!
        return memoDao.findMemo(session);
    }

    @Override
    public int saveMemo(Memo memo) {
        return memoDao.saveMemo(session, memo);
    }
}
