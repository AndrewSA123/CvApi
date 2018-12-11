package com.qa.service;

import com.qa.persistence.domain.Comment;

public interface ICommentService {
	
	public String createComment(Comment comment);
	
	public String deleteComment(Long id);
	
	public String updateComment(Long id, Comment comment);
	
	public Iterable<Comment> getAll();
	
	public Comment getComment(Long id);
	

}
