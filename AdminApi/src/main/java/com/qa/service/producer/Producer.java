package com.qa.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.AdminConstants;
import com.qa.persistence.domain.Admin;

@RestController
public class Producer {
	
	@Autowired
	private JmsTemplate jms;
	
	
	@PostMapping
	public Admin persistAdmin(Admin admin) {
		 jms.convertAndSend(AdminConstants.queueName, admin);
		 return admin;
	}

}
