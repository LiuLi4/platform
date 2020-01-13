package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.dao.AllianceNoticeDao;
import com.bjfu.inspect.service.AllianceNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllianceNoticeServiceImpl implements AllianceNoticeService {

    @Autowired
    private AllianceNoticeDao noticeDao;

    @Override
    public int save(AllianceNotice notice) {
        int ans = 0;
        try{
            ans =  noticeDao.save(notice);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int update(AllianceNotice notice) {
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
    public List<AllianceNotice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public AllianceNotice findById(int noticeId) {
        return noticeDao.findById(noticeId);
    }

    @Override
    public List<AllianceNotice> findPage(int page, int limit) {
        return noticeDao.findPage(page, limit);
    }

    @Override
    public List<AllianceNotice> findByAuthor(Integer authorId) {
        return noticeDao.findByAuthor(authorId);
    }
}
