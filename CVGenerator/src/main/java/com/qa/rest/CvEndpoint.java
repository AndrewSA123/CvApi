package com.qa.rest;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qa.persistence.domain.CV;
import com.qa.service.ICvService;

@CrossOrigin
@RestController
@RequestMapping("${endpoint.base}")
public class CvEndpoint implements ICvEndpoint{

	@Autowired
	private ICvService service;
	
	@Override
	@PostMapping("${endpoint.create}")
	public CV createCV(@PathVariable("id") Long id, @RequestBody MultipartFile CV) throws IOException {
		return service.createCV(id, CV);
	}

}
