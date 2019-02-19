/***
 * 分页样式函数
 * @param pageNum 当前页码
 * @param pageSize 当前页面可显示条数
 * @param totalPage 总页数
 * @param totalRecord 总记录数
 * @param start 页面显示的开始页
 * @param end 页面显示的结束页
 * @returns
 */
function pagination(pageNum,pageSize,totalPage,totalRecord,start,end){
	var pageStr = "";
	$(".pageContainer").empty();
	pageStr+= "<ul class='pageList'>";
	pageStr+= "<li class='first_page' onclick='goToFristPage(1)'>首页</li>";
	pageStr+= "<li class='prev_page' onclick='goToPrevPage()'>前一页</li>";
	for(var i=1;i<=end;i++){
		if(i==pageNum){
			pageStr+= "<li class='page_active'>"+i+"</li>";
		}else{
			pageStr+= "<li class='page' onclick='changePageNum("+i+")'>"+i+"</li>";
		}
	}
	pageStr+= "<li class='next_page' onclick='goToNextPage("+totalPage+")'>后一页</li>";
	pageStr+= "<li class='last_page' onclick='goToLastPage("+totalPage+")'>末页</li>";
	pageStr+= "<li>共 "+totalPage+" 页</li>";
	pageStr+= "<li>共 "+totalRecord+" 条记录</li>";
	pageStr+= "<li>每页 <select id='change_size' onchange='changePageSize()'>";
	if(pageSize==10){
		pageStr+= "<option value='10' selected='selected'>10</option>";
		pageStr+= "<option value='20'>20</option>";
		pageStr+= "<option value='50'>50</option>";
	}else if(pageSize==20){
		pageStr+= "<option value='10'>10</option>";
		pageStr+= "<option value='20' selected='selected'>20</option>";
		pageStr+= "<option value='50'>50</option>";
	}else if(pageSize==50){
		pageStr+= "<option value='10'>10</option>";
		pageStr+= "<option value='20'>20</option>";
		pageStr+= "<option value='50' selected='selected'>50</option>";
	}
	pageStr+= "</select> 条</li> ";
	pageStr+= "</ul>";
	$(".pageContainer").append(pageStr);
}

/**
 * 更改页面可显示条数函数。
 * 当页面选择条数与之前相同时，方法直接结束。
 * new_size 新的页面显示条数
 * page_size 当前页面显示条数
 * 更改完成后做一次请求刷新页面
 * @returns
 */
function changePageSize(){
	var new_size = $("#change_size").val();
	var page_size = $("#page_size").val();
	if(new_size==page_size){
		return;
	}else{
		$("#page_size").val(new_size);
	}
	pageSelectLoad();
}

/**
 * 更改当前页码，并且访问对应页码的数据
 * 若更改的页码与当前页面相同则跳出函数
 * @param pageNum 要更改的页面
 * page_num 当前页码
 * @returns
 */
function changePageNum(pageNum){
	var page_num = $("#page_num").val();
	if(pageNum==page_num){
		return;
	}else{
		$("#page_num").val(pageNum);
	}
	pageSelectLoad();
}

/**
 * 跳转首页函数
 * @param pageNum 首页页码
 * @returns
 */
function goToFristPage(pageNum){
	changePageNum(pageNum);
}

/**
 * 跳转末页函数
 * @param pageNum 末页页码
 * @returns
 */
function goToLastPage(pageNum){
	changePageNum(pageNum);
}

/**
 * 跳转都上一页函数
 * 当已经是首页，则跳出函数
 * @returns
 */
function goToPrevPage(){
	var page_num = $("#page_num").val();
	if(page_num==1){
		return;
	}else{
		changePageNum(parseInt(page_num)-1);
	}
}

/**
 * 跳转到下一页函数
 * 当已经是末页，则跳出函数
 * @param lastPageNum 当前页面最大页面数，也就是末页
 * @returns
 */
function goToNextPage(lastPageNum){
	var page_num = $("#page_num").val();
	if(page_num==lastPageNum){
		return;
	}else{
		changePageNum(parseInt(page_num)+1);
	}
}