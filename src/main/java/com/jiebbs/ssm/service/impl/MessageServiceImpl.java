package com.jiebbs.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.dao.MessageMapper;
import com.jiebbs.ssm.dao.ReviewMapper;
import com.jiebbs.ssm.dao.UserMapper;
import com.jiebbs.ssm.pojo.Message;
import com.jiebbs.ssm.pojo.MyPageHelper;
import com.jiebbs.ssm.pojo.User;
import com.jiebbs.ssm.service.IMessageService;
import com.jiebbs.ssm.vo.MessageDetailVO;
import com.jiebbs.ssm.vo.MessageFormVO;

/**
 * 留言服务类
 * @author weijie
 * @version
 */
@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Override
	public ServerResponse<MyPageHelper> selectAllMessage(int pageNum,int pageSize) {
		//判断从第几条开始显示
		int messageRow = 0; 
		int totalRecord = 0;
		totalRecord = messageMapper.selectTotalRecord();
		if(totalRecord>0) {
			List<Message> msgList = null;
			if(totalRecord<=pageSize) {
				msgList = messageMapper.selectAllMessage(messageRow,pageSize);
			}else {
				messageRow = pageSize*(pageNum-1);
				msgList = messageMapper.selectAllMessage(messageRow,pageSize);
			}
			MyPageHelper helper = new MyPageHelper(totalRecord, pageNum, pageSize);
			List<MessageFormVO> mesgfromVOList = new ArrayList<>();
			for(Message msg:msgList) {
				int reviewCount = reviewMapper.selectTotalRecordByMid(msg.getId());
				if(msg.getUid()!=null&&msg.getUid()!=0) {
					User user = userMapper.selectByPrimaryKey(msg.getUid());
					if(null!=user) {
						MessageFormVO msgFormVO = new MessageFormVO();
						msgFormVO.setId(msg.getId());
						msgFormVO.setUsername(user.getUsername());
						msgFormVO.setTitle(msg.getTitle());
						msgFormVO.setContent(msg.getContent());
						msgFormVO.setCreateDate(msg.getCreateDate());
						msgFormVO.setLastUpdateDate(msg.getLastUpdateDate());
						msgFormVO.setReviewCount(reviewCount);
						mesgfromVOList.add(msgFormVO);
					}
				}else {
					MessageFormVO msgFormVO = new MessageFormVO();
					msgFormVO.setId(msg.getId());
					msgFormVO.setUsername("匿名游客");
					msgFormVO.setTitle(msg.getTitle());
					msgFormVO.setContent(msg.getContent());
					msgFormVO.setCreateDate(msg.getCreateDate());
					msgFormVO.setLastUpdateDate(msg.getLastUpdateDate());
					msgFormVO.setReviewCount(reviewCount);
					mesgfromVOList.add(msgFormVO);
				}
			}
			helper.setData(mesgfromVOList);  
			return ServerResponse.createBySuccess("查询成功", helper);
		}
		return ServerResponse.createBySuccessMessage("查询没有任何留言");
	}

	@Override
	public ServerResponse addMessageByCheckUserLogin(Object userInfo, String title, String content) {
		if(userInfo!=null) {
			User user = (User)userInfo;
			Integer uid = user.getId();
			Message mesg = new Message();
			mesg.setUid(uid);
			mesg.setTitle(title);
			mesg.setContent(content);
			int result = messageMapper.insert(mesg);
			if(result>0) {
				return ServerResponse.createBySuccessMessage("新增留言成功");
			}else {
				return ServerResponse.createByErrorMessage("新增留言出错，请联系网站管理员!");
			}
		}else {
			Message mesg = new Message();
			mesg.setUid(0); //匿名游客留言默认id为0
			mesg.setTitle(title);
			mesg.setContent(content);
			int result = messageMapper.insert(mesg);
			if(result>0) {
				return ServerResponse.createBySuccessMessage("新增留言成功");
			}else {
				return ServerResponse.createByErrorMessage("新增留言出错，请联系网站管理员!");
			}
		}
	}

	@Override
	public ServerResponse<MessageDetailVO> selectMessageById(Integer id) {
		Message mesg = messageMapper.selectByPrimaryKey(id);
		if(null!=mesg) {
			if(mesg.getUid()!=0) {
				User user = userMapper.selectByPrimaryKey(mesg.getUid());
				if(user!=null) {
					MessageDetailVO mesgDeVO = new MessageDetailVO();
					mesgDeVO.setId(mesg.getId());
					mesgDeVO.setUid(mesg.getUid());
					mesgDeVO.setUsername(user.getUsername());
					mesgDeVO.setTitle(mesg.getTitle());
					mesgDeVO.setContent(mesg.getContent());
					mesgDeVO.setCreateDate(mesg.getCreateDate());
					mesgDeVO.setLastUpdateDate(mesg.getLastUpdateDate());
					return ServerResponse.createBySuccess("留言查询成功", mesgDeVO);
				}
				return ServerResponse.createByErrorMessage("用户不存在，可能是网站存在错误，请联系管理人员"); 
			}else {
				MessageDetailVO mesgDeVO = new MessageDetailVO();
				mesgDeVO.setId(mesg.getId());
				mesgDeVO.setUid(mesg.getUid());
				mesgDeVO.setUsername("匿名游客");
				mesgDeVO.setTitle(mesg.getTitle());
				mesgDeVO.setContent(mesg.getContent());
				mesgDeVO.setCreateDate(mesg.getCreateDate());
				mesgDeVO.setLastUpdateDate(mesg.getLastUpdateDate());
				return ServerResponse.createBySuccess("留言查询成功", mesgDeVO);
			}
		}else {
			return ServerResponse.createByErrorMessage("留言不存在或被删除");
		}
	}
}
