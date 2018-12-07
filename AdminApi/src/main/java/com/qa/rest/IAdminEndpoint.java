package com.qa.rest;

import java.util.Optional;

import com.qa.persistence.domain.Admin;

public interface IAdminEndpoint {
	
	public Admin createAdmin(Long id, Admin admin);
	
	public String deleteAdmin(Long id);
	
	public Admin updateAdmin(Long id, Admin newAdmin);
	
	public Iterable<Admin> getAllAdmins();
	
	public Optional<Admin> getAdmin(Long id);
	
	public String createComment(Long id, String comment);

}
