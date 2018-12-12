package com.qa.service;

import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Admin;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.domain.User;

@Service
public interface IServiceLayer {

	public String createUser(User user);
	
	public String createCv(CV cv);
	
	public String createComment(Comment comment);
	
	public String createAdmin(Admin admin);
	
}
