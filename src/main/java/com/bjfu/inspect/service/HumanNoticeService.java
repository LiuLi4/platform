package com.bjfu.inspect.service;

import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.bean.HumanNotice;

import java.util.List;

public interface HumanNoticeService {
    int save(HumanNotice notice);
    int update(HumanNotice notice);
    int delete(Integer id);
    List<HumanNotice> findPage(int page, int limit);
    List<HumanNotice> findByAuthor(Integer authorId);
    List<HumanNotice> findAll();
    HumanNotice findById(String hrId);
}
