package com.qa.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.CV;

public class ConsumeUsers implements IConsumeUsers{

	@Autowired
	private RestTemplate rest;
	
	@Override
	public CV createCv(CV cv) {
		return rest.postForObject("${endpoint.consume}" + "/" + cv.getUser_id(), cv, CV.class);
	}

}
