package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ProfilePictures")
public class ProfilePicture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long picture_id;
	@Lob
	private byte[] picture;
	private Long user_id;

	public ProfilePicture() {

	}

	public ProfilePicture(byte[] picture, Long id) {
		this.user_id = id;
		this.picture = picture;
	}

	public Long getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(Long picture_id) {
		this.picture_id = picture_id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

}
