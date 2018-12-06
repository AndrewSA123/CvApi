package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.Comment;

@Component
public class CommentTransfer {

	
	@Autowired
	private RestTemplate rest;
	
	
	public String send(Comment pojoComment) {
	
		rest.postForEntity("andyURL on CV/", pojoComment, Object.class);
		return "Comment has been successfully transfered";
	}
}
