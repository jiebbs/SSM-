package com.jiebbs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiebbs.ssm.pojo.Review;

public interface ReviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Review record);

    int insertSelective(Review record);

    Review selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
    
    List<Review> getReviews(@Param(value="mid")Integer mid,@Param(value="messageRow")int messageRow,@Param(value="pageSize")int pageSize);
    
    int selectTotalRecordByMid(@Param(value="mid")Integer mid);
}