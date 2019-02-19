package com.jiebbs.ssm.service;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.pojo.User;

public interface IUserService {

	public ServerResponse<User> login(String username,String password);
	
	public ServerResponse<User> register(User user);
}
