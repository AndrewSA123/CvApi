package com.qa.service;

import java.util.Optional;

import com.qa.persistence.domain.Admin;

public interface IAdminService {

	public Admin createAdmin(Long id, Admin admin);
	
	public String deleteAdmin(Long id);
	
	public Admin updateAdmin(Long id, Admin newAdmin);
	
	public Iterable<Admin> getAllAdmins();
	
	public Optional<Admin> getAdmin(Long id);
	
	public String createComment(Long admin_id, Long user_id, String comment);
	
}
