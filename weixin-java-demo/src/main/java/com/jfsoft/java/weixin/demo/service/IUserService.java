package com.jfsoft.java.weixin.demo.service;

import com.jfsoft.java.weixin.demo.model.User;

/**
 * Created by JAVA on 2017/6/7.
 */

public interface IUserService {
    int insert(User user) throws Exception;
    int selectUserByOpenID(String openID) throws Exception;
    int updateSubState(String openID) throws Exception;
}
