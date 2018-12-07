package com.qa.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ConsumeComment implements IConsumeComment{

	@Autowired
	private RestTemplate rest;
	
	@Override
	public String sendComment(Long admin_id, Long user_id, String comment) {
		return rest.postForObject("${endpoint.comsume}" + "/" + admin_id + "/" + user_id, comment, String.class);
	}

}
