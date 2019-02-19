package com.jiebbs.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.pojo.MyPageHelper;
import com.jiebbs.ssm.service.IMessageService;
import com.jiebbs.ssm.vo.MessageDetailVO;

@Controller
@RequestMapping(value="/message")
public class MessageController {
	
	@Autowired
	private IMessageService iMessageService;
	
	/**
	 * 查询所有页面留言（不管是否登录）
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/selectAllMessage_nl.do")
	@ResponseBody
	public ServerResponse<MyPageHelper> selectAllMessage(HttpSession session,int pageSize,int pageNum){
			ServerResponse<MyPageHelper> resp = iMessageService.selectAllMessage(pageNum,pageSize);
			return resp;
	}
	
	@RequestMapping(value="/addMessage.do")
	@ResponseBody
	public ServerResponse addMessage(HttpSession session,String title,String content) {
		if(session.getAttribute("login")!=null&&session.getAttribute("userInfo")!=null) {
			Object userInfo = session.getAttribute("userInfo");
			ServerResponse resp = iMessageService.addMessageByCheckUserLogin(userInfo, title, content);
			return resp;
		}else {
			ServerResponse resp = iMessageService.addMessageByCheckUserLogin(null, title, content);
			return resp;
		}
	}
	
	@RequestMapping(value="/MessageDetail.do")
	@ResponseBody
	public ServerResponse<MessageDetailVO> selectMessageById(Integer id) {
		ServerResponse<MessageDetailVO> resp = iMessageService.selectMessageById(id); 
		return resp;
	}
	
}
