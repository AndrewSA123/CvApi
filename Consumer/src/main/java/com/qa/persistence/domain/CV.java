package com.qa.persistence.domain;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "cvs")
public class CV implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cv_id;
	private String fileName;
	@Lob
	private byte[] contents;
	private Long user_id;

	public CV() {
	}

	public CV(Long id, String fileName, byte[] cv) throws IOException {
		this.user_id = id;
		this.fileName = fileName;
		this.contents = cv;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	public Long getCv_id() {
		return cv_id;
	}

	public void setCv_id(Long cv_id) {
		this.cv_id = cv_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

}