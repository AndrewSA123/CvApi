package com.qa.service;

import com.qa.persistence.domain.CV;
import org.bson.types.Binary;

public interface ICvService {

	public CV createCV(Long id, Binary CV);
	
}
