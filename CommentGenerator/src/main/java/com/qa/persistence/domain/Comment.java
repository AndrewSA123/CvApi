package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comment_id;
	private String comment;
	private Long admin_id;
	private Long cv_id;
	private Long user_id;
	
	public Comment() {
		
	}
	
	public Comment(Long admin_id, Long user_id, String comment, Long cv_id) {
		this.admin_id = admin_id;
		this.user_id = user_id;
		this.comment = comment;
		this.cv_id = cv_id;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getComment_id() {
		return comment_id;
	}

	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public Long getCv_id() {
		return cv_id;
	}

	public void setCv_id(Long cv_id) {
		this.cv_id = cv_id;
	}

	
}