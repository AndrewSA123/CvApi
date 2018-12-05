package com.qa.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.Constant;
import com.qa.peristence.domain.Users;

@Service
public class UserService implements IUserService{

	@Override
	public String createUser(Users username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Long id, Users username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Users> getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
