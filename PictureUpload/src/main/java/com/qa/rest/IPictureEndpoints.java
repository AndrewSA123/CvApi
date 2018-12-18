package com.qa.rest;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IPictureEndpoints {

	public String createPicture(Long user_id, MultipartFile picture) throws IOException;

	public String updatePicture(Long user_id, MultipartFile picture) throws IOException;

	public String deletePicture(Long user_id);

	public ResponseEntity<ByteArrayResource> getPicture(Long id);

}
