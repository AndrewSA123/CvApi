package com.qa.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qa.persistence.domain.CV;

@Service
public class CvService implements ICvService{

	@Override
	public CV createCV(Long id, MultipartFile CV) throws IOException {
		return new CV(id, CV.getOriginalFilename(), CV.getInputStream());
	}

}
