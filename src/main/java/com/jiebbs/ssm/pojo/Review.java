package com.jiebbs.ssm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review {
    private Integer id;

    private Integer mid;

    private Integer uid;
    
    private Integer reviewLevel;
    
    private String reviewUsername;
    
    private String messageOrReviewContent;

    private String reviewContent;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;
    
	public Review() {
		
	}
	
	public Review(Integer id, Integer mid, Integer uid, Integer reviewLevel, String reviewUsername,
			String messageOrReviewContent, String reviewContent, Date createDate, Date lastUpdateDate) {
		super();
		this.id = id;
		this.mid = mid;
		this.uid = uid;
		this.reviewLevel = reviewLevel;
		this.reviewUsername = reviewUsername;
		this.messageOrReviewContent = messageOrReviewContent;
		this.reviewContent = reviewContent;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
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

	public String getReviewUsername() {
		return reviewUsername;
	}

	public void setReviewUsername(String reviewUsername) {
		this.reviewUsername = reviewUsername;
	}
	
}