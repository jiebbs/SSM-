package com.jiebbs.ssm.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewVO {
	
	private Integer id;

    private Integer mid;

    private Integer uid;
    
    private String username;
    
    private String reviewUsername;

    private Integer reviewLevel;
    
    private String messageOrReviewContent;

    private String reviewContent;
    
    private Integer floor;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

	public ReviewVO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReviewUsername() {
		return reviewUsername;
	}

	public void setReviewUsername(String reviewUsername) {
		this.reviewUsername = reviewUsername;
	}

	public Integer getReviewLevel() {
		return reviewLevel;
	}

	public void setReviewLevel(Integer reviewLevel) {
		this.reviewLevel = reviewLevel;
	}

	public String getMessageOrReviewContent() {
		return messageOrReviewContent;
	}

	public void setMessageOrReviewContent(String messageOrReviewContent) {
		this.messageOrReviewContent = messageOrReviewContent;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
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

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}  
	
}
