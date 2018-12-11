package com.qa.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String createCv(@PathVariable("id") Long id, @RequestParam MultipartFile CV) throws IOException {
		return service.createCv(id, CV);
	}

	@Override
	@DeleteMapping("${endpoint.delete]")
	public String deleteCv(@PathVariable("id") Long id) {
		return service.deleteCv(id);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public String updateCv(@PathVariable("id")Long id, @RequestParam MultipartFile cv) throws IOException {
		return service.updateCv(id, cv);
	}

	@Override
	@GetMapping("${endpoint.getall}")
	public Iterable<CV> getall() {
		return service.getall();
	}

	@Override
	@GetMapping("${endpoint.get}")
	public byte[] getCv(@PathVariable("id") Long id) {
		return service.getCv(id);
	}

}
