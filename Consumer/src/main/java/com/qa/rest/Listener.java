package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qa.persistence.domain.Admin;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.domain.User;
import com.qa.service.IServiceLayer;

@Component
@CrossOrigin
public class Listener {

	@Autowired
	private IServiceLayer service;
	
	@JmsListener(destination = "UserQueue", containerFactory = "jmsContainerFactory")
	public String consumeUsers(User user) {
		return service.createUser(user);
	}
	
	@JmsListener(destination = "AdminQueue", containerFactory = "jmsContainerFactory")
	public String consumeAdmins(Admin admin) {
		return service.createAdmin(admin);
	}
	
	@JmsListener(destination = "CommentQueue", containerFactory = "jmsContainerFactory")
	public String consumeComments(Comment comment) {
		return service.createComment(comment);
	}
	
	@JmsListener(destination = "CvQueue", containerFactory = "jmsContainerFactory")
	public String consumeCvs(CV cv) {
		return service.createCv(cv);
	}
	
}
