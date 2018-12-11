package com.qa.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qa.constants.CvConstants;
import com.qa.persistence.domain.CV;
import com.qa.persistence.repository.IMySqlRepository;

@Service
public class CvService implements ICvService{

	@Autowired
	private IMySqlRepository repo;
	
	private CV temp;
	
	@Override
	public String createCv(Long id, MultipartFile CV) throws IOException {
		temp = new CV(id, CV.getOriginalFilename(), CV.getBytes());
		repo.save(temp);
		return CvConstants.create;
	}

	@Override
	public String deleteCv(Long id) {
		repo.deleteById(id);
		return CvConstants.delete;
	}

	@Override
	public String updateCv(Long id, MultipartFile cv) throws IOException {
		temp = new CV(id, cv.getOriginalFilename(), cv.getBytes());
		return null;
	}

	@Override
	public Iterable<CV> getall() {
		return repo.findAll();
	}

	@Override
	public byte[] getCv(Long id) {
		return repo.findById(id).get().getContents();
	}

}
