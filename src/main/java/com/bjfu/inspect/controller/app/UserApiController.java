package com.bjfu.inspect.controller.app;

import com.alibaba.fastjson.JSONObject;
import com.bjfu.inspect.bean.Users;
import com.bjfu.inspect.common.MD5Util;
import com.bjfu.inspect.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserApiController {
    @Autowired
    private UsersService usersService;

    //返回用户id，是否是管理员
    @RequestMapping("/login")
    public JSONObject loginApi(@RequestParam("uName") String uName, @RequestParam("uPassword") String uPassword){
        Users true_user = usersService.findByName(uName);
        JSONObject response = new JSONObject();
        //返回-1表示登陆失败
        response.put("userId", -1);
        response.put("userType", -1);
        if (true_user != null && true_user.getuPassword()!= null && MD5Util.checkPassword(uPassword, true_user.getuPassword())){
            //登陆成功
            response.put("userId", true_user.getuId());
            //0表示普通用户，1表示管理员
            response.put("userType", true_user.getuType());
        }
        return response;
    }

    @RequestMapping("/register")
    public JSONObject registerPost(@RequestParam("uName") String uName,
                               @RequestParam("uPassword") String uPassword,
                               @RequestParam("uGender") int uGender,
                               @RequestParam("uAge") int uAge,
                               @RequestParam("uTrueName") String uTrueName,
                               @RequestParam("uNumber") String uNumber,
                               @RequestParam("telephoneNum") String telephoneNum) {
        JSONObject response = new JSONObject();
        if(usersService.isExist(uName)) {
            response.put("state", "0");
            response.put("message", "该用户名已存在！");
        }else{
            //默认情况下注册的都是普通用户
            Users user = new Users(uName, MD5Util.EncoderByMd5(uPassword), uGender, uAge, uTrueName, uNumber, telephoneNum, 0);
            usersService.save(user);
            response.put("state", "1");
            response.put("message", "注册成功！");
        }
        return response;
    }

    @RequestMapping("/delete")
    public Boolean deleteApi(@RequestParam("uName") String uName){
        Users true_user = usersService.findByName(uName);
        int ans = 0;
        if (!StringUtils.isEmpty(true_user)){
            ans = usersService.deleteById(true_user.getuId());
        }
        return (ans > 0);
    }

    @RequestMapping("/update")
    public JSONObject updateApi(@RequestParam("uName") String uName,
                             @RequestParam("uPassword") String uPassword,
                             @RequestParam("uId") int uId){
        JSONObject response = new JSONObject();
        if(usersService.isExist(uName)) {
            response.put("state", "0");
            response.put("message", "该用户名已存在！");
        }
        Users users = usersService.findByName(uName);
        users.setuPassword(uPassword);
        usersService.update(users);
        response.put("state", "1");
        response.put("message", "用户更新成功！");
        return response;
    }

    @RequestMapping("/show")
    public List<Users> show(){
        return usersService.findAll();
    }
}
