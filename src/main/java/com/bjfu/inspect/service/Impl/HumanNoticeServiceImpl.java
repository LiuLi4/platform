package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.bean.HumanNotice;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.dao.AllianceNoticeDao;
import com.bjfu.inspect.dao.HumanNoticeDao;
import com.bjfu.inspect.service.AllianceNoticeService;
import com.bjfu.inspect.service.HumanNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanNoticeServiceImpl implements HumanNoticeService {

    @Autowired
    private HumanNoticeDao noticeDao;

    @Override
    public int save(HumanNotice notice) {
        int ans = 0;
        try{
            ans =  noticeDao.save(notice);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int update(HumanNotice notice) {
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
    public List<HumanNotice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public HumanNotice findById(String hrId) {
        return noticeDao.findById(hrId);
    }

    @Override
    public List<HumanNotice> findPage(int page, int limit) {
        return noticeDao.findPage(page, limit);
    }

    @Override
    public List<HumanNotice> findByAuthor(Integer authorId) {
        return noticeDao.findByAuthor(authorId);
    }
}
