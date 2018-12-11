package com.qa.rest;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import com.qa.persistence.domain.CV;

public interface ICvEndpoint {
	
	public CV createCV(Long id, MultipartFile CV) throws IOException;

}
