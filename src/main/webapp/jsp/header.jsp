<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jiebbs.ssm.pojo.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>头部菜单</title>
<link rel="stylesheet" href="http://localhost:8080/myProject/css/header.css" type="text/css"/>
<script type="text/javascript" src="http://localhost:8080/myProject/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/myProject/js/header.js"></script>
</head>
<body>
	<!-- 头部菜单栏 -->
	<div class="headBarTool">
			<div class="btn-container">
				<div class="headBarTool-BtnGroup">
				<span>
				欢迎 !
					<c:choose>
						<c:when test="${sessionScope.userInfo.username!=null&&sessionScope.login=='login'}">
							${sessionScope.userInfo.username}&nbsp;
							<a href="#" onclick="logout()">退出</a>&nbsp;&nbsp;
						</c:when>
						<c:otherwise>
							匿名游客&nbsp;&nbsp;
							<a href="#"  onclick="switchHideOrDisplay(this)">登录</a>&nbsp;&nbsp;
							<a href="#"  onclick="switchHideOrDisplay(this)">注册</a>&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
				</span>
				</div>
			</div>
		</div>
		
	<!-- 登录框 -->
	<div class="loginContainer" id="loginBlock" style="display: none">
		<div class="headerContainer">
			<div class="headTitle">
				<span>用户登录</span>
			</div>
		</div>
		<div class="loginBodyContainer">
			<div class="loginBox">
				<form action="http://localhost:8080/myProject/user/login.do" method="post" id="loginForm">
					<input type="text" placeholder="账号" name="loginName" id="loginName"/><br/>
					<input type="password" placeholder="密码" name="loginPassword" id="loginPassword"/>
				</form>
			</div>
		</div>
		<div class="loginErrorMsg">
		
		</div>
		<div class="loginFooterContainer">
			<div class="loginBtnGroup">
				<button type="button" class="btn-submit" onclick="login()">登录</button>
				<button type="button" class="btn-reset" onclick="loginReset()">重置</button>
			</div>
		</div>
	</div>
	
	<!-- 注册框 -->
	<div class="registerContainer" id="registerBlock" style="display:none">
		<div class="headerContainer">
			<div class="headTitle">
				<span>用户快速注册</span>
			</div>
		</div>
		<div class="registerBodyContainer">
			<div class="registerBox">
				<form action="" method="post">
					<input type="text" placeholder="账号" name="regUsername" id="regUsername"/><br/>
					<input type="password" placeholder="第一次密码" name="regPassword1" id="regPassword1"/>
					<input type="password" placeholder="再输入一次密码" name="regPassword2" id="regPassword2"/>
				</form>
			</div>
		</div>
		<div class="registerErrorMsg">
		
		</div>
		<div class="registerFooterContainer">
			<div class="registerBtnGroup">
				<button type="button" class="btn-submit" onclick="register()">注册</button>
				<button type="button" class="btn-reset" onclick="registerReset()">重置</button>
			</div>
		</div>
	</div>
</body>
</html>