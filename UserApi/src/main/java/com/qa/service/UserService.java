package com.qa.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.peristence.domain.Users;
import com.qa.persistence.repository.IUserRepo;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepo userRepo;

	@Autowired
	private Users user;

	public String createUser(String userName, String password, String email, String address, String firstName, String secondName) {
		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		user.setFirstName(firstName);
		user.setSecondName(secondName);
		userRepo.save(user);
		return "User Account Added Successfully";
	}

	public Iterable<Users> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<Users> getUserById(Long Id) {
		return userRepo.findById(Id);
	}

	public String deleteUser(Long Id) {
		userRepo.deleteById(Id);
		return "User Successfully Deleted";
	}

}
