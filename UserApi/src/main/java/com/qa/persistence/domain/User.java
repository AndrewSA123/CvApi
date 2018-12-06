package com.qa.persistence.domain;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Document(collection = "users")
public class User {

	@Id
	@Field("_id")
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private List<CV> CVObject;
	private List<String> taggedList;
	private boolean flagged = false;

	public User() {

	}

	public User(String userName, String password, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = userName;
		this.password = password;
	}

	public User(String userName, String password, String firstName, String lastName, CV CV) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.CVObject.add(CV);
		this.username = userName;
		this.password = password;
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

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public List<String> getTaggedList() {
		return taggedList;
	}

	public void setTaggedList(List<String> taggedList) {
		this.taggedList = taggedList;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CV getCVObject(Long id) {
		return CVObject.get(Math.toIntExact(id));
	}

	public void setCVObject(CV cVObject) {
		CVObject.add(cVObject);
	}
	
	public List<CV> getCVList() {
		return CVObject;
	}
	public void setCvComment(Comment comment) {
		for(CV cv : getCVList()) {
			if(cv.getId() == comment.getCVID()) {
				cv.setComment(comment);
			}
		}
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}


}
