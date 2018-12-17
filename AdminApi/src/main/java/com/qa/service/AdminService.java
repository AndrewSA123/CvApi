package com.qa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.AdminConstants;
import com.qa.persistence.domain.Admin;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.service.producer.Producer;
import com.qa.util.AdminUtil;
@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminUtil util;
	
	@Autowired
	private IMySqlRepository repo;
	
	@Autowired
	private Producer producer;
	
	@Override
	public String createAdmin(Long id, Admin admin) {
//		if(repo.findById(id).get().isSuperAdmin() == true) {
			producer.persistAdmin(admin);
			repo.save(admin);
			return AdminConstants.create;
//		}
//		return AdminConstants.fail;
	}

	@Override
	public String deleteAdmin(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return AdminConstants.delete;
		}
		return AdminConstants.fail;
	}

	@Override
	public String updateAdmin(Long id, Admin newAdmin) {
		if(repo.findById(id).isPresent()) {
			repo.save(util.updateAdmin(repo.findById(id).get(), newAdmin));
			return AdminConstants.update;
		}
		return AdminConstants.fail;
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
	public String getEmail(Long id) {
		Optional<Admin> admin = repo.findById(id);
		if(admin.isPresent()){
			return admin.get().getEmail();
		}
		return null;
	}

}
