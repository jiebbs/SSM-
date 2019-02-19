package com.jiebbs.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.jiebbs.ssm.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
    
    User selectByUsername(@Param(value="username")String username);
}