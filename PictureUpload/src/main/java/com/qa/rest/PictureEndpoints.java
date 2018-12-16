package com.qa.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qa.service.IPictureService;

@RestController
@CrossOrigin
@RequestMapping("${endpoint.base}")
public class PictureEndpoints implements IPictureEndpoints {

	@Autowired
	private IPictureService service;

	@Override
	@PostMapping("${endpoint.create}")
	public String createPicture(Long user_id, MultipartFile picture) throws IOException {
		return service.createPicture(user_id, picture);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public String updatePicture(Long user_id, MultipartFile picture) throws IOException {
		return service.updatePicture(user_id, picture);
	}

	@Override
	@DeleteMapping("${ednpoint.delete}")
	public String deletePicture(Long user_id) {
		return service.deletePicture(user_id);
	}

	@Override
	@GetMapping("${endpoint.get}")
	public ResponseEntity<ByteArrayResource> getPicture(Long id) {
		return service.getPicture(id);
	}

}
