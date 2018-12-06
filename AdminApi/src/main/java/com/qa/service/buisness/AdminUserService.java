package com.qa.service.buisness;

import java.util.Optional;

import com.qa.persistence.domain.AdminUser;

public interface AdminUserService {

	String addAdminAccount(String userName, String password);

	Iterable<AdminUser> getAllAdminAccounts();

	Optional<AdminUser> getAdminAccount(Long adminId);
	
	String updateAdminAccount(Long adminId, String userName, String password);

	String deleteAdminAccount(Long adminId);


}
