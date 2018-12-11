package com.qa.rest;

import com.qa.persistence.domain.Comment;

public interface ICommentEndpoint {
	
	public String createComment(Comment comment);
	
	public String deleteComment(Long id);
	
	public String updateComment(Long id, Comment comment);
	
	public Comment getComment(Long id);
	
	public Iterable<Comment> getAll();

}
