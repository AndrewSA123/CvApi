package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.AdminUser;
import com.qa.service.buisness.AdminUserService;

@CrossOrigin
@RequestMapping("${URL.base}")
@RestController
public class AdminUserEndpoints {

	@Autowired
	private AdminUserService service;

	@GetMapping("${URL.method.getAllAdminAccounts}")
	public Iterable<AdminUser> getAllAdminAccounts() {
		return service.getAllAdminAccounts();
	}

	@GetMapping("${URL.method.getAdminAccount}")
	public Optional<AdminUser> getAdminAccount(@PathVariable("adminId") Long adminId) {
		return service.getAdminAccount(adminId);
	}

	@PostMapping("${URL.method.addAdminAccount}")
	public String addAdminAccount(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return service.addAdminAccount(userName, password);
	}

	@DeleteMapping("${URL.method.deleteAdminAccount}")
	public String deleteAdminAccount(@PathVariable("adminId") Long adminId) {
		return service.deleteAdminAccount(adminId);
	}

}
