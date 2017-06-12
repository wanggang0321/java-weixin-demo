package com.jfsoft.java.weixin.demo.dao;

import com.jfsoft.java.weixin.demo.model.User;

public interface UserMapper {
    /**
     * 储存用户信息
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 防止重复插入数据
     * @param openID
     * @return
     */
    Integer selectUserByOpendID(String openID);

    int insertSelective(User record);

    int updateSubState(String openID);

}