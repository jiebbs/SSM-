<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost:8080/myProject/css/messageDetail.css" type="text/css"/>
<link rel="stylesheet" href="http://localhost:8080/myProject/css/pagination.css" type="text/css">
<script type="text/javascript" src="http://localhost:8080/myProject/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/myProject/js/messageDetail.js"></script>
<script type="text/javascript" src="http://localhost:8080/myProject/js/pagination.js"></script>
<title>留言详情页</title>
</head>
<body>
	<div class="indexHeadContainer">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="indexMainTitleContainer">
		<div class="indexMainTitleBox">
			<span>留言详情页面</span>
		</div>
	</div>
	<div class="reviewMessageContainer" >
			<jsp:include page="reviewMessage.jsp"></jsp:include>
	</div>
	<div class="messageDetailContainer">
		<div class="functionContainer">
			<div class="functionBox">
				<div class="function_button_group">
					<button type="button"  onclick="back_to_index()"> 返回主页 </button>
				</div>
			</div>
		</div>
		<div class="messageDetailBox">
			
		</div>
		<div class="dividing_line_container">
			<div class="dividing_line_box">
			 	<HR>
			</div> 
		</div>
		<div class="reviewDetailBox">
		
		</div>
		<input type="hidden" value="10" id="page_size"/>
		<input type="hidden" value="1" id="page_num">
		<div class="pageContainer">
		</div>
		<div class="messageDetail_footter">
		<div class="position:relative;height:100px">
			<p>@copyright jiebbs</p>
		</div>
		</div>
	</div>
</body>
</html>