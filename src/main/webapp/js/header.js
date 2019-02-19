jQuery(document).ready(function(){
	
})

//定义函数如果是想自身调用，请传入自身信息
function switchHideOrDisplay(obj){
	var tagText = $(obj).text();
	if(tagText=="登录"){
		//判断登录模块是否显示，若显示点击则隐藏，如果隐藏则显示
		//同时如果注册模块显示，则将其隐藏
		if($("#loginBlock").is(":hidden")){
			if(!$("#registerBlock").is(":hidden")){
				$("#registerBlock").hide();
			}
			$("#loginBlock").show();
		}else{
			$("#loginBlock").hide();
		}
	}else if(tagText=="注册"){
		//判断注册模块是否显示，若显示点击则隐藏，如果隐藏则显示
		//同时如果登录页模块显示，则将其隐藏
		if($("#registerBlock").is(":hidden")){
			if(!$("#loginBlock").is(":hidden")){
				$("#loginBlock").hide();
			}
			$("#registerBlock").show();
		}else{
			$("#registerBlock").hide();
		}
	}
}

//登录请求
function login(){
	var name = $("#loginName").val();
	var pwd = $("#loginPassword").val();
	jQuery.ajax({
		type:"post",
		url:"http://localhost:8080/myProject/user/login.do",
		data:{username:name,password:pwd},
		cache:true,
		async:false,
		dataType:"json",
		success:function(data){
			if(data.message=="登录成功"){
				location.reload();
			}else{
				$(".loginErrorMsg").empty();
				var errorMsg = "<span class='loginErrorMsg'>"+data.message+"</span>"
				$(".loginErrorMsg").append(errorMsg);
			}
		}
	});
}

//登出请求
function logout(){
	jQuery.ajax({
		type:"get",
		url:"http://localhost:8080/myProject/user/logout.do",
		data:{},
		cache:false,
		async:false,
		dataType:"json",
		success:function(data){
			alert(data.message);
			location.reload();
		}
	});
}

//注册请求
function register(){
	var name = $("#regUsername").val();
	var pwd1 = $("#regPassword1").val();
	var pwd2 =  $("#regPassword2").val();
	if(pwd1==pwd2){
		jQuery.ajax({
			type:"post",
			url:"http://localhost:8080/myProject/user/register.do",
			data:{username:name,password:pwd1},
			cache:true,
			async:false,
			dataType:"json",
			success:function(data){
				if(data.message=="登录成功"){
					location.reload();
				}else{
					$(".registerErrorMsg").empty();
					var errorMsg = "<span class='registerErrorMsg'>"+data.message+"</span>"
					$(".registerErrorMsg").append(errorMsg);
				}
			}
		});
	}else{
		$(".registerErrorMsg").empty();
		var errorMsg = "<span class='registerErrorMsg'>第一密码必须与第二次密码相同</span>"
		$(".registerErrorMsg").append(errorMsg);
	}
}




//登录输入重置
function loginReset(){
	$("#loginName").val("");
	$("#loginPassword").val("");
}

//注册输入重置
function registerReset(){
	$("#regUsername").val("");
	$("#regPassword1").val("");
	$("#regPassword2").val("");
}


