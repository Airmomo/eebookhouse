package com.eebookhouse.service;

import com.eebookhouse.entity.Remark;

import java.util.List;

public interface RemarkService {
    List<Remark> getRemarkList();
    List<Remark> getRemarkListByBookId(Integer bookId);
    boolean addRemark(Remark remark);
    boolean deleteRemarkById(Integer id);
}
