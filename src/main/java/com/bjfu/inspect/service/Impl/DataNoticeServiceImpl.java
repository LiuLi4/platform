package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.dao.DataNoticeDao;
import com.bjfu.inspect.service.DataNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataNoticeServiceImpl implements DataNoticeService {

    @Autowired
    private DataNoticeDao noticeDao;

    @Override
    public int save(DataNotice notice) {
        int ans = 0;
        try{
            ans =  noticeDao.save(notice);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int update(DataNotice notice) {
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
    public List<DataNotice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public List<DataNotice> findByType(String type) {
        return noticeDao.findByType(type);
    }

    @Override
    public DataNotice findById(String adId) {
        return noticeDao.findById(adId);
    }

    @Override
    public List<DataNotice> findPage(int page, int limit) {
        return noticeDao.findPage(page, limit);
    }

    @Override
    public List<DataNotice> findByAuthor(Integer authorId) {
        return noticeDao.findByAuthor(authorId);
    }


}
