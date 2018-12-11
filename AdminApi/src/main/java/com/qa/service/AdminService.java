package com.qa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Admin;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.util.AdminUtil;
import com.qa.webservices.IConsumeComment;
@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminUtil util;
	
	@Autowired
	private IMySqlRepository repo;
	
	@Autowired
	private IConsumeComment rest;
	
	@Override
	public Admin createAdmin(Long id, Admin admin) {
		if(repo.findById(id).get().isSuperAdmin() == true) {
			return repo.save(admin);
		}
		return null;
	}

	@Override
	public String deleteAdmin(Long id) {
		repo.deleteById(id);
		return "Change me to a constant";
	}

	@Override
	public Admin updateAdmin(Long id, Admin newAdmin) {
		return repo.save(util.updateAdmin(repo.findById(id).get(), newAdmin));
	}

	@Override
	public Iterable<Admin> getAllAdmins() {
		return repo.findAll();
	}

	@Override
	public Optional<Admin> getAdmin(Long id) {
		return repo.findById(id);
	}

	@Override
	public String createComment(Long admin_id, Long user_id, String comment) {
		return rest.sendComment(admin_id, user_id, comment);
	}

}
