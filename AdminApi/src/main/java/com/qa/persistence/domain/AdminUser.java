package com.qa.persistence.domain;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class AdminUser {

	@Id
	private Long _id;
	private String userName;

	private String password;

	public AdminUser() {

	}

	public Long get_id() {
		return _id;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "PojoAccount [adminId=" + _id + ", userName=" + userName + ", password=" + password + "]";
	}

}
