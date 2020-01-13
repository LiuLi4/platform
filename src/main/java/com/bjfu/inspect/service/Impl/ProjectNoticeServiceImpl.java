package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.bean.ProjectNotice;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.dao.DataNoticeDao;
import com.bjfu.inspect.dao.ProjectNoticeDao;
import com.bjfu.inspect.service.DataNoticeService;
import com.bjfu.inspect.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectNoticeServiceImpl implements ProjectNoticeService {

    @Autowired
    private ProjectNoticeDao noticeDao;

    @Override
    public int save(ProjectNotice notice) {
        int ans = 0;
        try{
            ans =  noticeDao.save(notice);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int update(ProjectNotice notice) {
        int ans = 0;
        try{
            ans =  noticeDao.update(notice);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int delete(Integer id) {
        int ans = 0;
        try{
            ans =  noticeDao.delete(id);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public List<ProjectNotice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public ProjectNotice findById(String pId) {
        return noticeDao.findById(pId);
    }

    @Override
    public List<ProjectNotice> findPage(int page, int limit) {
        return noticeDao.findPage(page, limit);
    }

    @Override
    public List<ProjectNotice> findByAuthor(Integer authorId) {
        return noticeDao.findByAuthor(authorId);
    }
}
