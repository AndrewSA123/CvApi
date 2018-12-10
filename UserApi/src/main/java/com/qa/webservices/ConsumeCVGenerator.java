package com.qa.webservices;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.UserConstants;
import com.qa.persistence.domain.CV;

@RestController
public class ConsumeCVGenerator implements IConsumeCvGenerator {

	@Autowired
	private RestTemplate rest;

	@Override
	public CV createCV(Long id, Binary cv) {
		return rest.postForObject(UserConstants.CvUrl, cv, CV.class);
	}

}
