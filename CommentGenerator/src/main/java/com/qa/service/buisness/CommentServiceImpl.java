package com.qa.service.buisness;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.persistence.domain.Comment;
import com.qa.util.CommentTransfer;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentTransfer commentTransfer;
	
	@Autowired
	private Comment pojoComment;
	
	@Override
	public String transferComment(Long adminId, Long userId, Long cvId, String comment) {
		
		pojoComment.setAdminId(adminId);
		pojoComment.setUserId(userId);
		pojoComment.setCvId(cvId);
		pojoComment.setComment(comment);
		
		commentTransfer.send(pojoComment);
		
		return "Info has been changed into pojo and transfered";
	}
	
	
	

}
