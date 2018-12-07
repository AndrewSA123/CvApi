package com.qa.rest;

import com.qa.persistence.domain.Comment;

public interface ICommentEndpoint {
	
	public Comment createComment(Long admin_id, Long user_id, String comment);

}
