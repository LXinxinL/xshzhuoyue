package com.icis.commonmapper.service;

import com.icis.commonmapper.pojo.UserInfo;

import java.util.List;

//用户接口
public interface IUserInfoService {
    //查询所有用户的数据方法
    public List<UserInfo> findAllUser();
    //通过主键(id)查询一个用户
    public UserInfo findUserByPrimaryKet(UserInfo userInfo);
    //根据其他字段查询数据
    public List<UserInfo> findUserByUserProperty(UserInfo userInfo);
    //根据名字name模糊查询
    public List<UserInfo> findUserByLikeName(UserInfo userInfo);
}
