package com.qa.service.buisness;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.util.CommentSender;

public class CommentServiceImpl implements CommentService {

	
	@Autowired
	private CommentSender commentInfo;
	
	public String addComment(Long adminId, Long userId, Long cvId, String comment) {
		
		commentInfo.send(adminId, userId, cvId, comment);
		
		return "Info has been sent to sender";
	}

}
