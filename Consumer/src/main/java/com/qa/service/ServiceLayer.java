package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.ConsumerConstants;
import com.qa.persistence.domain.Admin;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.domain.StringObject;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.IAdminRepo;
import com.qa.persistence.repository.ICommentRepo;
import com.qa.persistence.repository.ICvRepo;
import com.qa.persistence.repository.IStringRepo;
import com.qa.persistence.repository.IUserRepo;
@Service
public class ServiceLayer implements IServiceLayer{

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IAdminRepo adminRepo;
	
	@Autowired
	private ICommentRepo commentRepo;
	
	@Autowired
	private ICvRepo cvRepo;
	
	@Autowired
	private IStringRepo stringRepo;
	
	private StringObject object;
	
	
	@Override
	public String createString(String user) {
		object = new StringObject(user);
		stringRepo.save(object);
		
		return ConsumerConstants.create;
	}

}
