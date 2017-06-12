package com.jfsoft.java.weixin.demo.service.impl;

import com.jfsoft.java.weixin.demo.dao.UserMapper;
import com.jfsoft.java.weixin.demo.model.User;
import com.jfsoft.java.weixin.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JAVA on 2017/6/7.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    @Override
    public int selectUserByOpenID(String openID){
        return userMapper.selectUserByOpendID(openID);
    }

    @Override
    public int updateSubState(String openID){
        return userMapper.updateSubState(openID);
    }

}
