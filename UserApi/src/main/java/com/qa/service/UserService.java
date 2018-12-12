package com.qa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.CVConstants;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.util.UserUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	private IMySqlRepository repo;

	@Autowired
	private UserUtil util;


	private Long id = 0l;
	private Iterable<User> temp;

	private User foundUser;

	private Long setId() {
		temp = getAllUsers();
		for (User a : temp) {
			if (a.getUser_id() > id) {
				id = a.getUser_id();
			}
		}
		return id + 1;
	}

	@Override
	public String createUser(User user) {
		user.setUser_id(setId());
		repo.save(user);
		return CVConstants.create;
	}

	@Override
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return CVConstants.userDeleted;
	}

	@Override
	public Optional<User> findUserByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public String updateUser(Long id, User user) {
		repo.save(util.updateUser(repo.findById(id).get(), user));
		return CVConstants.update;
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repo.findAll();
	}

}
