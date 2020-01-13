package com.bjfu.inspect.service;

import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.DataNotice;

import java.util.List;

public interface DataNoticeService {
    int save(DataNotice notice);
    int update(DataNotice notice);
    int delete(Integer id);
    List<DataNotice> findPage(int page, int limit);
    List<DataNotice> findByAuthor(Integer authorId);
    List<DataNotice> findAll();
    List<DataNotice> findByType(String type);
    DataNotice findById(String adId);
}
