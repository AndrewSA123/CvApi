package com.qa.service;

import org.bson.types.Binary;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.CV;
@Service
public class CvService implements ICvService{

	@Override
	public CV createCV(Long id, Binary CV) {
		return new CV(id, CV);
	}

}
