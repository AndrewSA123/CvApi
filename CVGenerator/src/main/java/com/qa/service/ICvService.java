package com.qa.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.qa.persistence.domain.CV;

public interface ICvService {

	public String createCv(Long id, MultipartFile CV) throws IOException;
	
	public String deleteCv(Long id);
	
	public String updateCv(Long id, MultipartFile cv) throws IOException;
	
	public Iterable<CV> getall();
	
	public byte[] getCv(Long id);
	
}
