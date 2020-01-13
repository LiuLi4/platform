package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.LandNotice;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.dao.AllianceNoticeDao;
import com.bjfu.inspect.dao.LandNoticeDao;
import com.bjfu.inspect.service.AllianceNoticeService;
import com.bjfu.inspect.service.LandNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandNoticeServiceImpl implements LandNoticeService {

    @Autowired
    private LandNoticeDao noticeDao;

    @Override
    public int save(LandNotice notice) {
        int ans = 0;
        try{
            ans =  noticeDao.save(notice);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int update(LandNotice notice) {
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
    public List<LandNotice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public LandNotice findById(String ltId) {
        return noticeDao.findById(ltId);
    }

    @Override
    public List<LandNotice> findPage(int page, int limit) {
        return noticeDao.findPage(page, limit);
    }

    @Override
    public List<LandNotice> findByAuthor(Integer authorId) {
        return noticeDao.findByAuthor(authorId);
    }
}
