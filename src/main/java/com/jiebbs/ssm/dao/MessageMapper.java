package com.jiebbs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiebbs.ssm.pojo.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> selectAllMessage(@Param(value="messageRow")int messageRow,@Param(value="pageSize")int pageSize);

    int selectTotalRecord();
}