package com.qa.peristence.domain;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	
	@Id
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String secondName;
	private String email;
	private String address;
	private File cv;
	
	public Users() {
		
	}
	
	public Users(String firstName, String secondName, String email, String address, String username, String password, File cv) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.address = address;
	    this.username = username;
	    this.password = password;
	    this.cv = cv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public File getCv() {
		return cv;
	}

	public void setCv(File cv) {
		this.cv = cv;
	}

}
