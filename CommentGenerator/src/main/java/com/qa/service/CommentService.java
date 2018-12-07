package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Comment;
import com.qa.webservices.IConsumeCv;
@Service
public class CommentService implements ICommentService{

	@Autowired
	private IConsumeCv webService;
	
	private Comment newComment;
	
	@Override
	public Comment createComment(Long admin_id, Long user_id, String comment) {
		newComment = new Comment(admin_id, user_id, comment);
		return webService.createComment(newComment);
	}

}
