package com.qa.service;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IPictureService {

	public String createPicture(Long user_id, MultipartFile picture) throws IOException;

	public String updatePicture(Long user_id, MultipartFile picture) throws IOException;

	public String deletePicture(Long user_id);

	public ResponseEntity<ByteArrayResource> getPicture(Long id);

}
