package com.qa.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.PictureConstants;
import com.qa.persistence.domain.ProfilePicture;

@RestController
public class Producer {

	@Autowired
	private JmsTemplate jms;

	@PostMapping
	public ProfilePicture persistPicture(ProfilePicture picture) {
		jms.convertAndSend(PictureConstants.queueName, picture);
		return picture;
	}
}
