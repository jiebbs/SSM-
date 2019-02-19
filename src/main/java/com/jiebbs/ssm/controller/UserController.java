package com.jiebbs.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiebbs.ssm.common.ServerResponse;
import com.jiebbs.ssm.pojo.User;
import com.jiebbs.ssm.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(HttpServletRequest req,String username,String password) {
		HttpSession session = req.getSession(true);
		ServerResponse<User>  serverResponse =  iUserService.login(username,password);
		if(serverResponse.isSuccess()) {
			session.setAttribute("login", "login");
			session.setAttribute("userInfo", serverResponse.getData());
		}
		return serverResponse;
	}
	
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse logout(HttpSession session) {
		if(session!=null&&session.getAttribute("login")!=null&&session.getAttribute("userInfo")!=null) {
			session.removeAttribute("login");
			session.removeAttribute("userInfo");
			return ServerResponse.createBySuccessMessage("登出成功!");
		}
		return ServerResponse.createByErrorMessage("不在登录状态！");
	}
	
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> register(User user){
		ServerResponse<User> serverResponse = iUserService.register(user);
		return serverResponse;
	} 
}
