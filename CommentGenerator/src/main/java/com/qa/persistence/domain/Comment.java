package com.qa.persistence.domain;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Comment {
	
	@Id
	private Long adminId;
	private Long userId;
	private Long cvId;
	private String comment;
	
	public Comment() {
		
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCvId() {
		return cvId;
	}

	public void setCvId(Long cvId) {
		this.cvId = cvId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
