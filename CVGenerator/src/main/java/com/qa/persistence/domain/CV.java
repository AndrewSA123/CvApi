package com.qa.persistence.domain;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Document(collection = "cv")
public class CV {

	@Id
	@Field("_id")
	private Long id;
	private Binary CV;
	private List<Comment> comments;
	private Long user_id;

	public CV() {

	}

	public CV(Long id, Binary CV) {
		this.CV = CV;
		this.user_id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Binary getCV() {
		return CV;
	}

	public void setCV(Binary cV) {
		CV = cV;
	}
	

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(Comment comments) {
		this.comments.add(comments);
	}
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
