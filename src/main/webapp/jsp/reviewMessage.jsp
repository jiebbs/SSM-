<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost:8080/myProject/css/reviewMessage.css"/>
<title>回复</title>
</head>
<body>
	<div class="reviewContainer">
		<div class="button_group">
			<span class="review_close_button" onclick="closeAddMessageWindow()">关闭</span>
		</div>
		<div class="reviewBox">
			<div class="reviewHead">
				<span class="reviewTitle">回复框</span>
			</div>
			<div class="reviewBody">
				<div class="message_show_box">
					
				</div>
				<div class="reviewContent">
					<textarea id="content" name="content" cols="100" rows="10"
						placeholder="请输入留言..." style="resize:none"></textarea>
				</div>
			</div>
			<div>
				<input type="hidden" value="" id="review_mid"/>
				<input type="hidden" value="" id="review_rid"/>
				<input type="hidden" value="${sessionScope.userInfo.id}" id="review_uid"/>
				<input type="hidden" value="" id="review_name"/>
				<input type="hidden" value="" id="message_will_be_review"/>
			</div>
			<div class="reviewfooter">
				<div class="submit_button_group">
					<button type="button" onclick="reviewSubmit()">提交</button>
					<button type="button" onclick="reviewReset()">清空</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>