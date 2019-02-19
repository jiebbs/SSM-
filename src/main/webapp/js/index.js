/**
 * 隐藏显示留言框
 * @returns
 */
function addMessageHideOrShow(){
	if($(".addMessageContainer").is(":hidden")){
		$(".addMessageContainer").show();
	}else{
		$(".addMessageContainer").hide();
	}
}

/**
 * 清空留言框
 * @returns
 */
function addMessageReset(){
	var mesg = confirm("是否清空当前留言？");
	if(mesg==true){
		$("#title").val("");
		$("#content").val("");
	}else{
		return;
	}
}

/**
 * 提交留言
 * @returns
 */
function addMessageSubmit(){
	var title = $("#title").val();
	var content = $("#content").val();
	
	jQuery.ajax({
		type:"post",
		url:"http://localhost:8080/myProject/message/addMessage.do",
		data:{title:title,content:content},
		cache:true,
		async:false,
		dataType:"json",
		success:function(data){
			var mesg = data.message;
			if(mesg=="新增留言成功"){
				alert(mesg);
				window.location.reload();
			}else if(mesg=="新增留言出错，请联系网站管理员!"){
				alert(mesg);
				window.location.reload();
			}else{
				alert("发生未知错误！请联系网站管理员!");
				window.location.reload();
			}
		}
	});
}

/**
 * 隐藏留言框
 * @returns
 */
function closeAddMessageWindow(){
	$(".addMessageContainer").hide();
}


