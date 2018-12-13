package com.qa.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.CommentConstants;
import com.qa.persistence.domain.Comment;

@RestController
public class Producer {
	
	@Autowired
	private JmsTemplate jms;
	
	
	@PostMapping
	public Comment persistComment(Comment comment) {
		 jms.convertAndSend(CommentConstants.queueName, comment);
		 return comment;
	}

}
