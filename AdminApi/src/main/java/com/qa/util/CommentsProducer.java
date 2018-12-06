package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Comment;



@Component
public class CommentsProducer {
	
	@Autowired
	private Comment pojoComment;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	private Long inc = 0L;
	
	public String produce(Long userId, Long cvId, String comment) {
		inc++;
		pojoComment.set_id(inc);
		pojoComment.setUserId(userId);
		pojoComment.setCvId(cvId);
		pojoComment.setComment(comment);
		
		
		jmsTemplate.convertAndSend("CommentFromAdminUser", pojoComment);
		return "Comment has been successfully sent";
	}

}
