package com.qa.persistence.domain;


import javax.persistence.Id;

public class AdminUser {

	
	@Id
	private Long adminId;
	private String userName;
	private String password;

	public AdminUser() {
		

	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PojoAccount [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}

}
