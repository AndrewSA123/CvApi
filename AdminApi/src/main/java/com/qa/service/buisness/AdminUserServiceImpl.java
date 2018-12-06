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
	private AdminUser adminUser;

	private Long number = 0L;

	public String addAdminAccount(String userName, String password) {
		
		number++;
		adminUser.set_id(number);
		adminUser.setUserName(userName);
		adminUser.setPassword(password);
		adminUserRepo.save(adminUser);
		return "Admin Account Added Successfully";
	}

	public Iterable<AdminUser> getAllAdminAccounts() {
		return adminUserRepo.findAll();
	}

	public Optional<AdminUser> getAdminAccount(Long adminId) {
		return adminUserRepo.findById(adminId);
	}
	
	public String updateAdminAccount(Long adminId, String userName, String password) {
		
		adminUser.set_id(adminId);
		adminUser.setUserName(userName);
		adminUser.setPassword(password);
		adminUserRepo.save(adminUser);
		
	
		return "Admin Account has been successfully updated";
	}
	
	

	public String deleteAdminAccount(Long adminId) {
		adminUserRepo.deleteById(adminId);
		return "Admin User Successfully Deleted";

	}

}
