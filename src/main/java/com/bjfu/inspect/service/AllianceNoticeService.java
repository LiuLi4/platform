package com.bjfu.inspect.service;

import com.bjfu.inspect.bean.AllianceNotice;

import java.util.List;

public interface AllianceNoticeService {
    int save(AllianceNotice notice);
    int update(AllianceNotice notice);
    int delete(Integer id);
    List<AllianceNotice> findPage(int page, int limit);
    List<AllianceNotice> findByAuthor(Integer authorId);
    List<AllianceNotice> findAll();
    AllianceNotice findById(int noticeId);
}
