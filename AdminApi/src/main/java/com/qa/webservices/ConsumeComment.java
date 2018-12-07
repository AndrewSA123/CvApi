package com.qa.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ConsumeComment implements IConsumeComment{

	@Autowired
	private RestTemplate rest;
	
	@Override
	public String sendComment(Long id, String comment) {
		return rest.postForObject("" + "/" + id, comment, String.class);
	}

}
