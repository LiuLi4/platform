package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.bean.Users;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.dao.UsersDao;
import com.bjfu.inspect.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public boolean isExist(String uName) {
        boolean ans = false;
        Map<String, Object> ansMap = usersDao.isExist(uName);
        if(null != ansMap && ansMap.size() > 0){
            ans = true;
        }
        return ans;
    }

    @Override
    public int save(Users user) {
        int ans = 0;
        try{
            ans =  usersDao.save(user);
        }catch (Exception e){
            Log.info(this.getClass(), e.getMessage());
        }
        return ans;
    }

    @Override
    public int deleteById(int uId) {
        return usersDao.deleteById(uId);
    }

    @Override
    public List<Users> findPage(int page, int limit) {
        List<Users> ans = null;
        if(page > 0 && limit > 0){
            ans = usersDao.findPage((page - 1) * limit, limit);
        }
        return ans;
    }

    @Override
    public List<Users> findAll() {
         return usersDao.findAll();
    }

    @Override
    public Users findByName(String uName) {
        return usersDao.findByName(uName);
    }

    @Override
    public int usersNum(){
        return usersDao.usersNum();
    }

    @Override
    public int delete(String uName) {
        return usersDao.delete(uName);
    }

    @Override
    public int update(Users user) {
        return usersDao.update(user);
    }

    @Override
    public Users findById(int uId) {
        return usersDao.findById(uId);
    }

    @Override
    public List<Users> searchUser(String word) {
        return usersDao.searchUser("%" + word + "%");
    }


}
