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
	private String picture_name;
	private Long user_id;

	public ProfilePicture() {

	}

	public ProfilePicture(String name, byte[] picture, Long id) {
		this.picture_name = name;
		this.user_id = id;
		this.picture = picture;
	}

	
	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
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
