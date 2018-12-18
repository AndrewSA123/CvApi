package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qa.service.IServiceLayer;

@Component
@CrossOrigin
public class Listener {
	

	@Autowired
	private IServiceLayer service;
	
	@JmsListener(destination = "UserQueue", containerFactory = "jmsContainerFactory")
	public String consumeUsers(String user) {
		return service.createString(user);
	}
	
	@JmsListener(destination = "AdminQueue", containerFactory = "jmsContainerFactory")
	public String consumeAdmins(String admin) {
		return service.createString(admin);
	}
	
	@JmsListener(destination = "CommentQueue", containerFactory = "jmsContainerFactory")
	public String consumeComments(String comment) {
		return service.createString(comment);
	}
	
	@JmsListener(destination = "CvQueue", containerFactory = "jmsContainerFactory")
	public String consumeCvs(String cv) {
		return service.createString(cv);
	}
	
	@JmsListener(destination = "PictureQueue", containerFactory = "jmsContainerFactory")
	public String consumePicrture(String picture) {
		return service.createString(picture);
	}

}
