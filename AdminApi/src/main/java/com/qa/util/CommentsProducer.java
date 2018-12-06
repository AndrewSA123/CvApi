package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Comment;

@Component
public class CommentsProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(Long adminId, Comment comment) {
		comment.setAdminId(adminId);
		comment.setComment(comment.getComment());
		jmsTemplate.convertAndSend("CommentFromAdminUser", comment);
		return "Comment has been successfully sent";
	}

}
