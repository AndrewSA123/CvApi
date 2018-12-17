package com.qa.rest;

import java.io.IOException;

import com.qa.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
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

	@Override
	@PostMapping("${endpoint.create}")
	public String createCv(@PathVariable("id") Long id, @RequestParam MultipartFile CV) throws IOException {

		String tags = getTags(id);

		sendNotification(tags, id);

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
	public ResponseEntity<ByteArrayResource> getCv(@PathVariable("id") Long id) {
		return service.getCv(id);
	}

//	private boolean taggedByAdmin(Long id) {
//		int userInDbFlag = restTemplate.getForObject("localhost:8081/user/getflag/" + id, int.class);
//		return userInDbFlag == 1;
//	}

	private void sendNotification(String tags, Long uId) {
		String[] adminIds = tags.split("#");
		for (int i = 1; i < adminIds.length; i++) {
			sendEmail(adminIds[i], uId);
		}
	}

	private void sendEmail(String id, Long uId){
		String email = restTemplate.getForObject("http://localhost:8084/admin/getemail/"+id, String.class);
		String traineeUsername = restTemplate.getForObject("http://localhost:8081/user/getusername/"+uId, String.class);
		emailService.sendEmail(email, traineeUsername);
	}

	private String getTags(Long id) {
		return restTemplate.getForObject("http://localhost:8081/user/gettags/" + id, String.class);
	}


}
