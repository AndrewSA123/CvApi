package com.qa.service;

import com.qa.persistence.domain.Comment;

public interface ICommentService {
	
	public Comment createComment(Long admin_id, Long user_id, String comment);

}
