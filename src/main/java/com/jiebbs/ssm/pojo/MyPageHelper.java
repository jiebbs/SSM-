package com.jiebbs.ssm.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 分页类
 * @author weijie
 * @version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyPageHelper {
	
	private Integer start;
	private Integer end;
	private Integer totalPage;
	private Integer totalRecord;
	private Integer pageNum;
	private Integer pageSize;
	private Object data;
	
	public MyPageHelper(Integer totalRecord, Integer pageNum, Integer pageSize) {
		this.totalRecord = totalRecord;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		setTotalPage();
		setStart();
		setEnd();	
	}

	public void setStart() {
		if(pageNum-2<=0) {
			start = 1;
		}else {
			start = pageNum-2;
		}
	}
	
	public Integer getStart() {
		return start;
	}
	
	public void setEnd() {
		if(pageNum+2>totalPage) {
			end = totalPage;
		}else {
			end = pageNum+2;
		}
	}
	
	public Integer getEnd() {
		return end;
	}
	
	public void setTotalPage() {
		if(totalRecord!=0) {
			if((totalRecord/pageSize)!=0) {
				if((totalRecord%pageSize)>0) {
					totalPage = totalRecord/pageSize+1;
				}else {
					totalPage = totalRecord/pageSize;
				}
			}else {
				totalPage = 1;
			}
		}
	}
	
	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
