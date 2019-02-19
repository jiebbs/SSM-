jQuery(document).ready(function(){
	pageSelectLoad()
})

function pageSelectLoad(){
	var mid = getUrlParam("id");
	getMessageDetail(mid);
	getReviewDetail(mid);
}

/**
 * 
 * 返回主页
 * */
function back_to_index(){
	window.location.href="http://localhost:8080/myProject/index.jsp";
}

/**
 * 根据mid 获取对应文章的详情和回复详情
 * @param mid
 * @returns
 */
function getMessageDetail(mid){
	jQuery.ajax({
		type:"get",
		url:"http://localhost:8080/myProject/message/MessageDetail.do",
		data:{id:mid},
		cache:true,
		async:false,
		dataType:"json",
		success:function(data){
			var mesg = data.message;
			if(mesg=="留言查询成功"){
				var mesgInfo = data.data;
				var MessageDetail = "";
				$(".messageDetailBox").empty();
				MessageDetail += "<div class='userInfoBox'>";
				MessageDetail += "<img src='http://localhost:8080/myProject/images/defaultHeadImg.jpeg' alt='默认头像' width='100px' height='100px'/>";
				MessageDetail += "<div class='userInfo_username'>用户名："+mesgInfo.username+"</div>";
				MessageDetail += "<div class='messageInfo_createDate'>发布时间："+mesgInfo.createDate+"</div>";
				MessageDetail += "<div class='messageInfo_updateDate'>更新时间："+mesgInfo.lastUpdateDate+"</div>";
				MessageDetail += "</div>";
				MessageDetail += "<div class='mesgInfoBox'>";
				MessageDetail += "<div class='messageInfo_title'>标题："+mesgInfo.title+"</div>";
				MessageDetail += "<div class='function_box'>";
				MessageDetail += "<button type='button' class='review_button' onclick='message_review("+mesgInfo.id+","+'\"'+mesgInfo.title+'\"'+","+'\"'+mesgInfo.content+'\"'+")'>回复</button>";
				MessageDetail += "</div>";
				MessageDetail += "<div class='line_style'><HR></div>";
				MessageDetail += "<div class='messageInfo_content'>"+mesgInfo.content+"</div>";
				MessageDetail += "</div>";
				$(".messageDetailBox").append(MessageDetail);
			}else if(mesg=="用户不存在，可能是网站存在错误，请联系管理人员"){
				
			}else if(mesg=="留言不存在或被删除"){
				
			}
		}
	});
}

/**
 * 根据mid获取对应文章的回复
 * @param mid
 * @returns
 */
function getReviewDetail(mid){
	var pageSize = $("#page_size").val();
	var pageNum = $("#page_num").val();
	jQuery.ajax({
		type:"get",
		url:"http://localhost:8080/myProject/review/getReviews.do",
		data:{mid:mid,pageNum:pageNum,pageSize:pageSize},
		cache:true,
		async:false,
		dataType:"json",
		success:function(data){
			var mesg = data.message;
			if(mesg=="留言回复查询成功"){
				var helper = data.data;
				var reviewList = helper.data;
				var review_show_str = "";
				$(".reviewDetailBox").empty();
				$.each(reviewList,function(i,review){
					review_show_str+= "<div class='review_box'"+i+">"
					review_show_str+= "<div class='review_userInfoBox'>";
					review_show_str+= "<div class='review_floor'><span>第 "+review.floor+" 楼</span></div>";
					review_show_str+= "<img src='http://localhost:8080/myProject/images/defaultHeadImg.jpeg' alt='默认头像' width='100px' height='100px'/>";
					review_show_str+= "<div class='review_userInfo_username'>用户名："+review.username+"</div>";
					review_show_str+= "<div class='review_messageInfo_createDate'>回复时间："+review.createDate+"</div>";
					review_show_str+= "<div class='review_messageInfo_updateDate'>更新时间："+review.lastUpdateDate+"</div>";
					review_show_str+= "</div>";
					review_show_str+= "<div class='review_mesgInfoBox'>";
					review_show_str+= "<div class='review_function_box'>";
					review_show_str+= "<button type='button' class='review_review_button' onclick='review_review("+review.mid+","+review.id+","+'\"'+review.reviewContent+'\"'+","+'\"'+review.username+'\"'+")'>回复</button>";
					review_show_str+= "</div>";
					if(review.messageOrReviewContent!=null&&review.messageOrReviewContent!=""){
						if(review.uid!=0){
							review_show_str+= "<div class='review_messageInfo_messageOrReviewContent'>"+review.reviewUsername+":"+review.messageOrReviewContent+"</div>";
						}else{
							review_show_str+= "<div class='review_messageInfo_messageOrReviewContent'>匿名游客："+review.messageOrReviewContent+"</div>";	
						}
					}
					review_show_str+= "<div class='review_line_style'><HR></div>";
					review_show_str+= "<div class='review_messageInfo_content'>"+review.reviewContent+"</div>";
					review_show_str+= "</div>";
					review_show_str+= "</div>";
				})
				$(".reviewDetailBox").append(review_show_str);
				pagination(helper.pageNum,helper.pageSize,helper.totalPage,helper.totalRecord,helper.start,helper.end);
			}else if(mesg=="查询没有此留言回复"){
				
			}
		}
	})
}

/**
 * 回复框中填入标题和内容
 * 同时将mid和uid放入隐藏域方便后续提交
 * @param label 用于后端辨识提交的回复类型
 * @param mid 
 * @param uid
 * @param title
 * @param content
 * @returns
 */
function message_review(mid,title,content){
	var reviewStr = "";
	reviewStr += "<div class='showBox_title'>标题："+title+"</div>";
	reviewStr += "<div class='showBox_HR'><HR></div>";
	reviewStr += "<div class='showBox_content'>内容："+content+"</div>";
	$(".message_show_box").empty();
	$(".message_show_box").append(reviewStr);
	$("#review_mid").val(mid);
	reviewMessageHideOrShow();
}

/**
 * 
 * @param label
 * @param rid
 * @param uid
 * @param content
 * @returns
 */
function review_review(mid,rid,content,username){
	var reviewStr = "";
	reviewStr += "<div class='showBox_content'>"+username+"："+content+"</div>";
	$(".message_show_box").empty();
	$(".message_show_box").append(reviewStr);
	$("#review_mid").val(mid);
	$("#review_rid").val(rid);
	$("#review_name").val(username);
	$("#message_will_be_review").val(content);
	reviewMessageHideOrShow();
}

/**
 * 提交回复信息
 * rid为空时默认是针对主留言的回复，设置默认review_level为0
 * 当rid不为空时，review_level设置为对应的rid
 * @returns
 */
function reviewSubmit(){
	var mid = $("#review_mid").val();
	var rid = $("#review_rid").val();
	var uid = $("#review_uid").val();
	var username = $("#review_name").val();
	if(uid==""){
		uid=0;
	}
	var content = $("#content").val();
	if(rid==""){
		jQuery.ajax({
			type:"get",
			url:"http://localhost:8080/myProject/review/addReview.do",
			data:{mid:mid,rid:"0",uid:uid,content:content,message:null,reviewUsername:username},
			cache:true,
			async:false,
			dataType:"json",
			success:function(data){
				var mesg = data.message;
				if(mesg=="回复成功"){
					alert(mesg);
					window.location.reload();
				}
			}
		})	
	}else{
		var message = $("#message_will_be_review").val();
		jQuery.ajax({
			type:"get",
			url:"http://localhost:8080/myProject/review/addReview.do",
			data:{mid:mid,rid:rid,uid:uid,content:content,message:message,reviewUsername:username},
			cache:true,
			async:false,
			dataType:"json",
			success:function(data){
				var mesg = data.message;
				if(mesg=="回复成功"){
					alert(mesg);
					window.location.reload();
				}
			}
		})	
	}
}

/**
 * 清空回复框
 * @returns
 */
function reviewReset(){
	var mesg = confirm("是否清空当前留言？");
	if(mesg==true){
		$("#content").val("");
	}else{
		return;
	}
}

/**
 * 隐藏显示留言框
 * @returns
 */
function reviewMessageHideOrShow(){
	if($(".reviewMessageContainer").is(":hidden")){
		$(".reviewMessageContainer").show();
	}else{
		$(".reviewMessageContainer").hide();
	}
}

/**
 * 隐藏回复框
 * @returns
 */
function closeAddMessageWindow(){
	$(".reviewMessageContainer").hide();
}


/**
 * 获取URL中的参数
 * @param name
 * @returns
 */
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}