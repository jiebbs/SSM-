<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost:8080/myProject/css/index.css" type="text/css"/>
<script type="text/javascript" src="http://localhost:8080/myProject/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/myProject/js/index.js"></script>
<title> 留言板 </title>
</head>
<body>
	<div class="indexHeadContainer">
		<jsp:include page="jsp/header.jsp"></jsp:include>
	</div>
	<div class="indexMainTitleContainer">
		<div class="indexMainTitleBox">
			<span>jiebbsの留言板</span>
		</div>
	</div>
	<div class="indexBodyContainer">
		<div class="functionContainer">
			<div class="functionBox">
				<div class="function_button_group">
					<button type="button" onclick="addMessageHideOrShow()"> 留  言 </button>
				</div>
			</div>
		</div>
		<div class="addMessageContainer" >
			<jsp:include page="jsp/addMessage.jsp"></jsp:include>
		</div>
		<div class="messageFormContainer">
			<jsp:include page="jsp/messageForm.jsp"></jsp:include>
		</div>
		<div class="indexFooterContainer">
			<div class="position:relative;height:200px">
				<p>@copyright jiebbs</p>
				<p>build at 2019-02-19</p>
			</div>	
		</div>
	</div>
</body>
</html>