<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言页面</title>
</head>
<body>
	<div class="reviewContainer">
		<div class="button_group">
			<span class="addMessage_close_button" onclick="closeAddMessageWindow()">关闭</span>
		</div>
		<div class="reviewBox">
			<div class="reviewHead">
				<span class="reviewTitle">留言框</span>
			</div>
			<div class="reviewBody">
				<div class="reviewTheme">
					<input type="text" id="title" name="title" placeholder="标题" />
				</div>
				<div class="reviewContent">
					<textarea id="content" name="content" cols="100" rows="12"
						placeholder="请输入留言..." style="resize:none"></textarea>
				</div>
			</div>
			<div class="reviewfooter">
				<div class="submit_button_group">
					<button type="button" onclick="addMessageSubmit()">提交</button>
					<button type="button" onclick="addMessageReset()">清空</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>