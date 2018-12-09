package com.qa.rest;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.CV;
import com.qa.service.ICvService;

@RestController
@RequestMapping("${endpoint.base}")
public class CvEndpoint implements ICvEndpoint{

	@Autowired
	private ICvService service;
	
	@Override
	@GetMapping("${endpoint.create}")
	public CV createCV(@PathVariable("id") Long id, @RequestBody Binary CV) {
		return service.createCV(id, CV);
	}

}
