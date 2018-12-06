package com.qa.persistence.domain;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Comment {

	@Id

	private Long adminId;
	private String comment;

	public Comment() {

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
