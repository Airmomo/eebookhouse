package com.eebookhouse.service.Impl;

import com.eebookhouse.dao.BookMapper;
import com.eebookhouse.dao.RebateMapper;
import com.eebookhouse.entity.Rebate;
import com.eebookhouse.service.RebateService;
import com.eebookhouse.service.RemarkService;
import com.eebookhouse.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Comparator;
import java.util.List;

@Deprecated
public class RebateServiceImpl implements RebateService {

    @Override
    public List<Rebate> getRebateList() {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            RebateMapper mapper = sqlSession.getMapper(RebateMapper.class);
            return mapper.getRebateList();
        }
    }

    @Override
    public Double getRebate(Integer userLevel) {
        //待测试
        Double res = this.getRebateList()
                .stream()
                .filter(rebate -> userLevel > rebate.getLevel())
                .mapToDouble((rebate) -> rebate.getRebateRate())
                .summaryStatistics()
                .getMin();
        return res;
    }

}
