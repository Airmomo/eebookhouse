package com.eebookhouse.service.Impl;

import com.eebookhouse.dao.BookMapper;
import com.eebookhouse.dao.RemarkMapper;
import com.eebookhouse.dao.UserMapper;
import com.eebookhouse.entity.Remark;
import com.eebookhouse.service.RemarkService;
import com.eebookhouse.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemarkServiceImpl implements RemarkService {
    @Override
    public List<Remark> getRemarkList() {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            RemarkMapper mapper = sqlSession.getMapper(RemarkMapper.class);
            List<Remark> list = mapper.getRemarkList();
            return list;
        }
    }

    @Override
    public List<Remark> getRemarkListByBookId(Integer bookId) {
        return this.getRemarkList()
                .stream()
                .filter(remark -> remark.getBook().getId().intValue() == bookId)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addRemark(Remark remark) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            RemarkMapper mapper = sqlSession.getMapper(RemarkMapper.class);
            int row = mapper.addRemark(remark.getBook().getId(),
                    remark.getUser().getId(),
                    remark.getGrade(),
                    remark.getRemark(),
                    remark.getDate());
            return row > 0;
        }
    }

    @Override
    public boolean deleteRemarkById(Integer id) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            RemarkMapper mapper = sqlSession.getMapper(RemarkMapper.class);
            int row = mapper.deleteRemark(id);
            return row > 0;
        }
    }
}
