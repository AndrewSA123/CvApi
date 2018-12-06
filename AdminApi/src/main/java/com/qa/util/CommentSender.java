package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommentSender {

	@Autowired
	private RestTemplate rest;
	
	
	public String send(Long adminId, Long userId, Long cvId, String comment) {
	
		rest.postForEntity("url to post to/"+adminId +"/"+userId +"/" + cvId, comment, String.class);
		return "Comment has been successfully sent";
	}

}
