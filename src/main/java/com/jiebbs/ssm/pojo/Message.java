package com.jiebbs.ssm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    private Integer id;

    private Integer uid;

    private String title;

    private String content;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;
    
    private Integer reviewCount;

	public Message(Integer id, Integer uid, String title, String content, Date createDate, Date lastUpdateDate,
			Integer reviewCount) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
		this.reviewCount = reviewCount;
	}
	public Message(){}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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