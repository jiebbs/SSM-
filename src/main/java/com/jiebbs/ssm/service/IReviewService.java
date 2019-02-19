package com.jiebbs.ssm.service;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.pojo.MyPageHelper;

public interface IReviewService {
	
	public ServerResponse addReview(Integer mid,Integer rid,Integer uid,String content,String message,String reviewUsername) ;

	public ServerResponse<MyPageHelper> getReviews(Integer mid,Integer pageNum,Integer pageSize);
}
