package com.jiebbs.ssm.service;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.pojo.MyPageHelper;
import com.jiebbs.ssm.vo.MessageDetailVO;

public interface IMessageService {
	
	public ServerResponse<MyPageHelper> selectAllMessage(int pageNum,int pageSize);
	
	public ServerResponse addMessageByCheckUserLogin(Object userInfo,String title,String content) ;
	
	public ServerResponse<MessageDetailVO> selectMessageById(Integer id);
	
}
