package com.bjfu.inspect.service;

import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.bean.ProjectNotice;

import java.util.List;

public interface ProjectNoticeService {
    int save(ProjectNotice notice);
    int update(ProjectNotice notice);
    int delete(Integer id);
    List<ProjectNotice> findPage(int page, int limit);
    List<ProjectNotice> findByAuthor(Integer authorId);
    List<ProjectNotice> findAll();
    ProjectNotice findById(String pId);
}
