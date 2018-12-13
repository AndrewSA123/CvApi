package com.qa.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.CvConstants;
import com.qa.persistence.domain.CV;

@RestController
public class Producer {
	
	@Autowired
	private JmsTemplate jms;
	
	
	@PostMapping
	public CV persistCv(CV cv) {
		 jms.convertAndSend(CvConstants.queueName, cv);
		 return cv;
	}

}
