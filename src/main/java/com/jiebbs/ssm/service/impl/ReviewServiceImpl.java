package com.jiebbs.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.dao.ReviewMapper;
import com.jiebbs.ssm.dao.UserMapper;
import com.jiebbs.ssm.pojo.MyPageHelper;
import com.jiebbs.ssm.pojo.Review;
import com.jiebbs.ssm.pojo.User;
import com.jiebbs.ssm.service.IReviewService;
import com.jiebbs.ssm.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements IReviewService {
	
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ServerResponse addReview(Integer mid, Integer rid, Integer uid, String content,String message,String reviewUsername) {
		Review rev = new Review();
		rev.setMid(mid);
		if(uid==null) {
			rev.setUid(0);
		}else {
			rev.setUid(uid);
		}
		rev.setReviewLevel(rid);
		rev.setReviewUsername(reviewUsername);
		rev.setReviewContent(content);
		rev.setMessageOrReviewContent(message);
		int result = reviewMapper.insert(rev);
		if(result>0) {
			return ServerResponse.createBySuccessMessage("回复成功");
		}else {
			return ServerResponse.createByErrorMessage("回复失败，请重新尝试！");
		}
	}

	@Override
	public ServerResponse<MyPageHelper> getReviews(Integer mid,Integer pageNum,Integer pageSize) {
		Integer messageRow =0;
		List<Review> reviewList = null;
		int totalRecord = reviewMapper.selectTotalRecordByMid(mid);
		if(totalRecord<=pageSize) {
			reviewList = reviewMapper.getReviews(mid,messageRow,pageSize);
		}else {
			messageRow = pageSize*(pageNum-1);
			reviewList = reviewMapper.getReviews(mid,messageRow,pageSize);
		}
		if(totalRecord!=0) {
			List<ReviewVO> reviewVOList = new ArrayList<>();
			int floor = messageRow+1;
			for(Review rev:reviewList) {
				if(rev.getUid()!=null&&rev.getUid()!=0) {
					User user = userMapper.selectByPrimaryKey(rev.getUid());
					ReviewVO revVO = new ReviewVO();
					revVO.setId(rev.getId());
					revVO.setMid(rev.getMid());
					revVO.setUid(rev.getUid());
					revVO.setUsername(user.getUsername());
					revVO.setReviewUsername(rev.getReviewUsername());
					revVO.setReviewLevel(rev.getReviewLevel());
					revVO.setReviewContent(rev.getReviewContent());
					revVO.setCreateDate(rev.getCreateDate());
					revVO.setLastUpdateDate(rev.getLastUpdateDate());
					revVO.setMessageOrReviewContent(rev.getMessageOrReviewContent());
					revVO.setFloor(floor++);
					reviewVOList.add(revVO);
				}else {
					ReviewVO revVO = new ReviewVO();
					revVO.setId(rev.getId());
					revVO.setMid(rev.getMid());
					revVO.setUid(0);
					revVO.setUsername("匿名游客");
					revVO.setReviewUsername(rev.getReviewUsername());
					revVO.setReviewLevel(rev.getReviewLevel());
					revVO.setReviewContent(rev.getReviewContent());
					revVO.setCreateDate(rev.getCreateDate());
					revVO.setLastUpdateDate(rev.getLastUpdateDate());
					revVO.setMessageOrReviewContent(rev.getMessageOrReviewContent());
					revVO.setFloor(floor++);
					reviewVOList.add(revVO);
				}
			}
			MyPageHelper helper = new MyPageHelper(totalRecord, pageNum, pageSize);
			helper.setData(reviewVOList);
			return ServerResponse.createBySuccess("留言回复查询成功", helper);
		}else {
			return ServerResponse.createByErrorMessage("查询没有此留言回复");
		}
	}
	
	
}
