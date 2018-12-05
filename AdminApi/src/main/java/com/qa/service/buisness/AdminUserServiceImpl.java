package com.qa.service.buisness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.AdminUser;
import com.qa.persistence.repository.AdminUserRepository;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository adminUserRepo;

	@Autowired
	private AdminUser user;

	public String addAdminAccount(String userName, String password) {
		user.setUserName(userName);
		user.setPassword(password);
		adminUserRepo.save(user);
		return "Admin Account Added Successfully";
	}

	public Iterable<AdminUser> getAllAdminAccounts() {
		return adminUserRepo.findAll();
	}

	public Optional<AdminUser> getAdminAccount(Long adminId) {
		return adminUserRepo.findById(adminId);
	}

	public String deleteAdminAccount(Long adminId) {
		adminUserRepo.deleteById(adminId);
		return "Admin User Successfully Deleted";

	}

}
