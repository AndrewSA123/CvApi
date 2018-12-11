package com.qa.service;

import com.qa.persistence.domain.CV;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

public interface ICvService {

	public CV createCV(Long id, MultipartFile CV) throws IOException;
	
}
