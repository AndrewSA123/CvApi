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
	private String firstName;
	private String lastName;
	private Binary CV;
	private List<CV> CVObject;

	public User() {

	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String firstName, String lastName, Binary CV) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.CV = CV;
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

	public Binary getCV() {
		return CV;
	}

	public void setCV(Binary cV) {
		CV = cV;
	}

	public List<CV> getCVObject() {
		return CVObject;
	}

	public void setCVObject(CV cVObject) {
		CVObject.add(cVObject);
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
