package com.qa.rest;

import org.bson.types.Binary;

import com.qa.persistence.domain.CV;

public interface ICvEndpoint {
	
	public CV createCV(Long id, Binary CV);

}
