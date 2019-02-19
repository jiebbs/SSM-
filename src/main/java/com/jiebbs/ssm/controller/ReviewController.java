package com.jiebbs.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.pojo.MyPageHelper;
import com.jiebbs.ssm.service.IReviewService;

@Controller
@RequestMapping(value="/review")
public class ReviewController {

	@Autowired
	private IReviewService iReviewService;
	
	@RequestMapping(value="/addReview.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse addReview(Integer mid,Integer rid,Integer uid,String content,String message,String reviewUsername){
		ServerResponse resp = iReviewService.addReview(mid, rid, uid, content,message,reviewUsername);
		return resp;
	}
	
	@RequestMapping(value="/getReviews.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<MyPageHelper> getReviews(Integer mid,Integer pageNum,Integer pageSize){
		ServerResponse<MyPageHelper> resp = iReviewService.getReviews(mid,pageNum,pageSize);
		return resp;
	}
}
