package com.qa.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.UserConstants;
import com.qa.persistence.domain.User;

@RestController
public class Producer {
	
	@Autowired
	private JmsTemplate jms;
	
	
	@PostMapping
	public User persistUser(User user) {
		 jms.convertAndSend(UserConstants.queueName, user);
		 return user;
	}

}
