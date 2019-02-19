package com.jiebbs.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.dao.UserMapper;
import com.jiebbs.ssm.pojo.User;
import com.jiebbs.ssm.service.IUserService;
import com.jiebbs.ssm.util.StringUtil;

/**
 * 用户服务实现类
 * @author weijie
 * @version
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public ServerResponse<User> login(String username, String password) {
		User user = null;
		if(StringUtil.checkStr(username)) {
			if(StringUtil.checkStr(password)) {
				user = userMapper.selectByUsername(username);
				if(user!=null) {
					if(user.getPassword().equals(password)) {
						user.setPassword(null);
						return ServerResponse.createBySuccess("登录成功", user);
						
					}else {
						return ServerResponse.createByErrorMessage("用户登录密码错误");
					}
				}else {
					return ServerResponse.createByErrorMessage("此用户名未注册");
				}
			}else {
				return ServerResponse.createByErrorMessage("密码不能为空");
			}
		}else {
			return ServerResponse.createByErrorMessage("用户名不能为空");
		}
	}

	
	@Override
	public ServerResponse<User> register(User user) {
		if(!StringUtil.checkStr(user.getUsername())) {
			return ServerResponse.createByErrorMessage("用户名不能为空");
		}
		User seacherUser = userMapper.selectByUsername(user.getUsername());
		if(null!=seacherUser) {
			return ServerResponse.createByErrorMessage("用户名已存在");
		}
		int result = userMapper.insert(user);
		if(result>0) {
			return ServerResponse.createBySuccessMessage("注册成功"); 
		}
		return ServerResponse.createByErrorMessage("注册失败，请联系网站管理人员");
	}
	
	
}
