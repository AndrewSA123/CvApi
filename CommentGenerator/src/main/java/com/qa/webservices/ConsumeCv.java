package com.qa.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.Comment;
@Component
public class ConsumeCv implements IConsumeCv{

	@Autowired
	private RestTemplate rest;
	
	@Override
	public Comment createComment(Comment comment) {
		return rest.postForObject("${endpoint.consume}" + "/" + comment.getAdmin_id() + "/" + comment.getCVID(), comment, Comment.class);
	}

}
