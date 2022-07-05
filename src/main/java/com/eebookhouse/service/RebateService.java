package com.eebookhouse.service;

import com.eebookhouse.entity.Rebate;
import com.eebookhouse.entity.Remark;

import java.util.List;

@Deprecated
public interface RebateService {

    List<Rebate> getRebateList();
    Double getRebate(Integer userId);

}
