package com.bjfu.inspect;

import com.bjfu.inspect.bean.Users;
import com.bjfu.inspect.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersTest {
    @Autowired
    private UsersService usersService;
//    @Test
//    void userTest(){
////        // 添加 10 个用户
////        for(int i = 0; i < 10; i++){
//            usersService.save(new Users(50, "user" + 1, "password" + 1, 1));
////        }
////        // 是否存在
////        System.out.println("user0");
////        System.out.println("user10");
////        // 分页
////        System.out.println(usersService.findPage(2, 2).toArray().toString());
////        System.out.println(usersService.findPage(1, 3).toArray().toString());
////        // 查询全部
////        System.out.println(usersService.findAll().toArray().toString());
////        // 查询一条
////        System.out.println(usersService.findByName("user0").toString());
////        // 查询数量
////        System.out.println(usersService.usersNum());
////        // 删除
////        usersService.delete("user1");
////        // 修改
////        usersService.update(new Users(25, "admin", "admin", 0));
//    }
}
