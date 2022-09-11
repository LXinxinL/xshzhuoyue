package com.icis.commonmapper.service.impl;

import com.icis.commonmapper.mapper.UserInfoMapper;
import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

//用户接口实现类接口
@Service
public class IUserInfoServiceImpl implements IUserInfoService {
      //注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    //实现查询所有用户数据
    @Override
    public List<UserInfo> findAllUser() {
        //查询所有 select * from user_info;
        return userInfoMapper.selectAll();
    }
    //通过主键(id)查询一个用户
    @Override
    public UserInfo findUserByPrimaryKet(UserInfo userInfo) {
        // select * from user_info where id=?;
        return userInfoMapper.selectByPrimaryKey(userInfo);
    }
    //根据其他字段查询数据
    @Override
    public List<UserInfo> findUserByUserProperty(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }
    //根据名字name模糊查询
    @Override
    public List<UserInfo> findUserByLikeName(UserInfo userInfo) {
        //1,首先封装条件 %value%
        //模板  查询条件通过模板进行封装
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //根据名字模糊查询
        criteria.andLike("name","%"+userInfo.getName()+"%");
        //criteria.andGreaterThan("id",userInfo.getId());//拼接 并且id大于几
        //criteria.andGreaterThanOrEqualTo("id",userInfo.getId());//拼接 并且id大于或等于几

        return this.userInfoMapper.selectByExample(example);
    }


}
