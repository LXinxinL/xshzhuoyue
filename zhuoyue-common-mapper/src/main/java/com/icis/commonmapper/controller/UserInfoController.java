package com.icis.commonmapper.controller;

import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户控制器
@Controller
@ResponseBody//作用于该类下的所有方法
//@Controller和@ResponseBody 可以合二为一 为@RestController
//@RestController
public class UserInfoController {
    //注入service
    @Autowired
    private IUserInfoService userInfoService;

    //查询所有用户
    @RequestMapping("/getAllUser")
    public List<UserInfo> findAllUser(){
        return this.userInfoService.findAllUser();
    }

    //通过主键(id)查询一个用户
    @RequestMapping("/getUserByPrimaryKet")
    public UserInfo findUserByPrimaryKet(String uid){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(uid);
        return this.userInfoService.findUserByPrimaryKet(userInfo);
    }

    //根据其他字段查询数据  根据条件查询  条件封装到属性中  请求参数名称要与实体类的属性要保持一致才可以自动封装
    @RequestMapping("/getUserByUserProperty")
    public List<UserInfo> findUserByUserProperty(UserInfo userInfo){
        return this.userInfoService.findUserByUserProperty(userInfo);
    }

    //根据名字模糊查询
    @RequestMapping("/findByLikeName")
    public List<UserInfo> findUserByLikeName(UserInfo userInfo){
        return this.userInfoService.findUserByLikeName(userInfo);
    }
}
