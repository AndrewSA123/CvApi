package com.qa.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Util {

	private Gson gson;
	
	public String toJSON(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T fromJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
	
}
