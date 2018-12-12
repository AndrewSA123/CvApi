package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.constants.ConsumerConstants;
import com.qa.persistence.domain.Admin;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.IAdminRepo;
import com.qa.persistence.repository.ICommentRepo;
import com.qa.persistence.repository.ICvRepo;
import com.qa.persistence.repository.IUserRepo;

public class ServiceLayer implements IServiceLayer{

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IAdminRepo adminRepo;
	
	@Autowired
	private ICommentRepo commentRepo;
	
	@Autowired
	private ICvRepo cvRepo;
	
	
	@Override
	public String createUser(User user) {
		userRepo.save(user);
		return ConsumerConstants.create;
	}

	@Override
	public String createCv(CV cv) {
		cvRepo.save(cv);
		return ConsumerConstants.create;
	}

	@Override
	public String createComment(Comment comment) {
		commentRepo.save(comment);
		return ConsumerConstants.create;
	}

	@Override
	public String createAdmin(Admin admin) {
		adminRepo.save(admin);
		return ConsumerConstants.create;
	}

}
