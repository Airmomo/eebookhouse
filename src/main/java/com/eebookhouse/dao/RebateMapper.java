package com.eebookhouse.dao;

import com.eebookhouse.entity.Rebate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Deprecated
public interface RebateMapper {

    //获取所有折扣信息
    @Select("SELECT * FROM rebate")
    List<Rebate> getRebateList();

    //获取所有折扣信息
    @Select("SELECT * FROM rebate WHERE id=#{id}")
    Rebate getRebateById(@Param("id")Integer id);

}
