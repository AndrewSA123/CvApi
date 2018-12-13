package com.qa.util;

import org.springframework.stereotype.Component;

import com.qa.persistence.domain.User;

@Component
public class UserUtil {

	public User updateUser(User userToPersist, User newUser) {
		userToPersist = newUser;
		return userToPersist;
	}
	

}
