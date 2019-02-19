<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost:8080/myProject/css/messageForm.css" type="text/css">
<link rel="stylesheet" href="http://localhost:8080/myProject/css/pagination.css" type="text/css">
<script type="text/javascript" src="http://localhost:8080/myProject/js/messageForm.js"></script>
<script type="text/javascript" src="http://localhost:8080/myProject/js/pagination.js"></script>
<title></title>
</head>
<body>
	<div class="formContainer">
		<div class="tableContainer">
			<table class="formTable" >
				<thead>
					<tr class="titleRow">
						<th class="NO">序号</th>
						<th class="title">标题</th>
						<th class="content">内容摘要</th>
						<th class="author">作者</th>
						<th class="create-date">创建日期</th>
						<th class="update-date">最近更新日期</th>
						<th class="review-count">回复数</th>
						<th class="operation">操作</th>
					</tr>
				</thead>
				<tbody class="formBody" id="messageForm">	
				</tbody>
			</table>
		</div>
		<input type="hidden" value="10" id="page_size"/>
		<input type="hidden" value="1" id="page_num">
		<div class="pageContainer">
		</div>
	</div>
</body>
</html>