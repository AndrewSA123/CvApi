package com.qa.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qa.constants.CvConstants;
import com.qa.persistence.domain.CV;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.service.producer.Producer;

@Service
public class CvService implements ICvService{

	@Autowired
	private IMySqlRepository repo;
	
	private CV temp;
	
	@Autowired
	private Producer producer;
	
	@Override
	public String createCv(Long id, MultipartFile CV) throws IOException {
		temp = new CV(id, CV.getOriginalFilename(), CV.getBytes());
		producer.persistCv(temp);
		repo.save(temp);
		return CvConstants.create;
	}

	@Override
	public String deleteCv(Long id) {
		Optional<CV> cv = repo.findById(id);
		if(cv.isPresent()){
			repo.delete(cv.get());
			return CvConstants.delete;
		}
		return CvConstants.fail;
	}

	@Override
	public String updateCv(Long id, MultipartFile cv) throws IOException {
		if(repo.findById(id).isPresent()) {
			temp = new CV(id, cv.getOriginalFilename(), cv.getBytes());
			repo.save(temp);
			return CvConstants.update;
		}
		return CvConstants.fail;
	}

	@Override
	public Iterable<CV> getall() {
		return repo.findAll();
	}

	@Override
	public ResponseEntity<ByteArrayResource> getCv(Long id) {
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + repo.findById(id).get().getFileName() + "\"")
				.body(new ByteArrayResource(repo.findById(id).get().getContents()));
	}

	@Override
	public ResponseEntity<ByteArrayResource> getCvByUser(Long user_id) {
		if(repo.getCvByUser(user_id).isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + repo.getCvByUser(user_id).get().getFileName() + "\"")
					.body(new ByteArrayResource(repo.getCvByUser(user_id).get().getContents()));
		}
		return (ResponseEntity<ByteArrayResource>) ResponseEntity.badRequest();
		
	}

}
