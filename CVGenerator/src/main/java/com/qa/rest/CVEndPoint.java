package com.qa.rest;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qa.domain.CVEntity;
import com.qa.repository.CVEntityRepo;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(value = { "*" }, exposedHeaders = { "Content-Disposition" })
public class CVEndPoint {

	private final CVEntityRepo cvRepo;

	public CVEndPoint(CVEntityRepo cvRepo) {
		this.cvRepo = cvRepo;
	}

	@GetMapping
	public ResponseEntity<byte[]> getFile() {
		long amountOfFiles = cvRepo.count();
		Long randomPrimaryKey;

		if (amountOfFiles == 0) {
			return ResponseEntity.ok(new byte[0]);

		} else if (amountOfFiles == 1) {
			randomPrimaryKey = 1L;
		} else {
			randomPrimaryKey = ThreadLocalRandom.current().nextLong(1, amountOfFiles + 1);
		}

		CVEntity cvEntity = cvRepo.findById(randomPrimaryKey).get();
		HttpHeaders header = new HttpHeaders();

		header.setContentType(MediaType.valueOf(cvEntity.getContentType()));
		header.setContentLength(cvEntity.getData().length);
		header.set("Content-Disposition", "attachment; filename=" + cvEntity.getFileName());

		return new ResponseEntity<>(cvEntity.getData(), header, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> uploadNewFile(@NotNull @RequestParam("file") MultipartFile multipartFile)
			throws IOException {

		CVEntity cvEntity = new CVEntity(multipartFile.getOriginalFilename(), multipartFile.getContentType(),
				multipartFile.getBytes());

		cvRepo.save(cvEntity);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).build();

	}

}
