package com.qa.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qa.constants.PictureConstants;
import com.qa.persistence.domain.ProfilePicture;
import com.qa.persistence.repository.IMySqlRepo;

@Service
public class PictureService implements IPictureService {

	@Autowired
	private IMySqlRepo repo;

	private ProfilePicture temp;

	@Override
	public String createPicture(Long user_id, MultipartFile picture) throws IOException {
		repo.save(new ProfilePicture(picture.getOriginalFilename(), picture.getBytes(), user_id));
		return PictureConstants.create;
	}

	@Override
	public String updatePicture(Long user_id, MultipartFile picture) throws IOException {
		if (repo.findPictureByUser(user_id).isPresent()) {
			temp = repo.findPictureByUser(user_id).get();
			temp.setPicture(picture.getBytes());
			repo.save(temp);
			return PictureConstants.update;
		}
		return PictureConstants.create;
	}

	@Override
	public String deletePicture(Long user_id) {
		if (repo.findPictureByUser(user_id).isPresent()) {
			repo.delete(repo.findPictureByUser(user_id).get());
			return PictureConstants.delete;
		}
		return PictureConstants.fail;
	}

	@Override
	public ResponseEntity<ByteArrayResource> getPicture(Long id) {
		if (repo.findPictureByUser(id).isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename =\"" + repo.findPictureByUser(id).get().getPicture_name() + "\"")
					.body(new ByteArrayResource(repo.findPictureByUser(id).get().getPicture()));
		}
		return (ResponseEntity<ByteArrayResource>) ResponseEntity.notFound();

	}

}
