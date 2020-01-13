package com.bjfu.inspect.service;

import com.bjfu.inspect.bean.Users;

import java.util.List;

public interface UsersService {
    boolean isExist(String uName);
    int save(Users user);
    List<Users> findPage(int page, int limit);
    List<Users> findAll();
    Users findByName(String uName);
    int usersNum();
    int delete(String uName);
    int deleteById(int uId);
    int update(Users user);
    Users findById(int uId);
    List<Users> searchUser(String word);
}
