jQuery(document).ready(function(){
	messageSelect();
	rowColorChange();
})

function pageSelectLoad(){
	messageSelect();
	rowColorChange();
}

function messageSelect(){
	var pageSize = $("#page_size").val();
	var pageNum = $("#page_num").val();
	//表单信息请求
	jQuery.ajax({
		type:"get",
		url:"http://localhost:8080/myProject/message/selectAllMessage_nl.do",
		data:{"pageNum":pageNum,"pageSize":pageSize},
		cache:true,
		async:false,
		dataType:"json",
		success:function(data){
			if(data.message=="查询成功"){
				var helper = data.data;
				var mesgList = helper.data;
				var tableStr="";
				$("#messageForm").empty();
				if(mesgList.length>0){
					$.each(mesgList,function(i,msg){
						tableStr+= "<tr class='tableRow'>";
						tableStr+="<td>"+msg.id+"</td>";
						tableStr+="<td>"+msg.title+"</td>";
						tableStr+="<td>"+msg.content+"</td>";
						tableStr+="<td>"+msg.username+"</td>";
						tableStr+="<td>"+msg.createDate+"</td>";
						tableStr+="<td>"+msg.lastUpdateDate+"</td>";
						tableStr+="<td>"+msg.reviewCount+"</td>";
						tableStr+="<td>"+"<a href='http://localhost:8080/myProject/jsp/messageDetail.jsp?id="+msg.id+"'>查看详细</a>"+"</td>";
						tableStr+="</tr>"
						$("#messageForm").append(tableStr);
						tableStr = "";
					});
					pagination(helper.pageNum,helper.pageSize,helper.totalPage,helper.totalRecord,helper.start,helper.end);
				}
			}else{
				$("#messageForm").empty();
				tableStr+="<tr class='tableRow'><td colspan='8'>"+data.message+"</td></tr>";
				$("#messageForm").append(tableStr);
			}
		}
	});
}

function rowColorChange(){
	 var color = "#b1c7fc";
	 $(".formTable tr:odd td").css("background-color", color); //改变偶数行背景色
	 $(".formTable tr:odd").attr("bg", color);
	 $(".formTable tr:even").attr("bg", "#fff");
}
