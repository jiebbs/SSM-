package com.jiebbs.ssm.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 留言列表信息展示对象
 * @author weijie
 * @version
 */
public class MessageFormVO {
	private Integer id;
	
	private String username;
	
	private String title;

	private String content;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date lastUpdateDate;
	
	private Integer reviewCount;

	public MessageFormVO() {}
	
	public MessageFormVO(Integer id, String username, String title, String content, Date createDate,
			Date lastUpdateDate, Integer reviewCount) {
		this.id = id;
		this.username = username;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
		this.reviewCount = reviewCount;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	
}
