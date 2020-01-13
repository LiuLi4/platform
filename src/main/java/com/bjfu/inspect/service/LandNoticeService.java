package com.bjfu.inspect.service;

import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.LandNotice;

import java.util.List;

public interface LandNoticeService {
    int save(LandNotice notice);
    int update(LandNotice notice);
    int delete(Integer id);
    List<LandNotice> findPage(int page, int limit);
    List<LandNotice> findByAuthor(Integer authorId);
    List<LandNotice> findAll();
    LandNotice findById(String ltId);
}
