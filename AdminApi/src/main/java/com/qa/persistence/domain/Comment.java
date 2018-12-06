package com.qa.persistence.domain;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Comment {

	@Id
	//CommentId
	private Long _id;
	private Long adminId;
	private Long userId;
	private Long cvId;
	private String comment;
	
	public Comment() {
		
		
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
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

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	


	
	
	
}
