package com.qa.rest;

import java.io.IOException;

import com.qa.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.qa.persistence.domain.CV;
import com.qa.service.ICvService;

@CrossOrigin
@RestController
@RequestMapping("${endpoint.base}")
public class CvEndpoint implements ICvEndpoint{

	@Autowired
	private ICvService service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EmailService emailService;

	@Value("${endpoint.getemail}")
	private String getEmailEndpoint;

	@Value("${endpoint.getusername}")
	private String getUsername;

	@Value("${endpoint.gettags}")
	private String getTags;

	@Override
	@PostMapping("${endpoint.create}")
	public String createCv(@PathVariable("id") Long id, @RequestParam MultipartFile CV) throws IOException {
		String tags = getTags(id);
		if (!tags.equals("") && tags != null) {
			sendNotification(tags, id);
		}
		return service.createCv(id, CV);
	}

	@Override
	@DeleteMapping("${endpoint.delete}")
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
	public ResponseEntity<ByteArrayResource> getCv(@PathVariable("id") Long id) {
		return service.getCv(id);
	}

	private void sendNotification(String tags, Long uId) {
		String[] adminIds = tags.split("#");
		for (int i = 1; i < adminIds.length; i++) {
			sendEmail(adminIds[i], uId);
		}
	}

	private void sendEmail(String id, Long uId){
		String email = restTemplate.getForObject(getEmailEndpoint+id, String.class);
		String traineeUsername = restTemplate.getForObject(getUsername+uId, String.class);
		emailService.sendEmail(email, traineeUsername);
	}

	private String getTags(Long id) {
		return restTemplate.getForObject(getTags + id, String.class);
	}

	@Override
	@GetMapping("${endpoint.getbyuser}")
	public ResponseEntity<ByteArrayResource> getCvByUser(@PathVariable("user_id") Long user_id) {
		return service.getCvByUser(user_id);
	}


}
