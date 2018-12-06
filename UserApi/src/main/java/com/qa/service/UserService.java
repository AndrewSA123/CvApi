package com.qa.service;

import java.util.Optional;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.IMongoRepository;
import com.qa.util.UserUtil;
import com.qa.webservices.IConsumeCvGenerator;

@Service
public class UserService implements IUserService {

	@Autowired
	private IMongoRepository repo;

	@Autowired
	private UserUtil util;

	@Autowired
	private IConsumeCvGenerator rest;

	private Long id = 0l;
	private Iterable<User> temp;

	private Long setId() {
		temp = getAllUsers();
		for (User a : temp) {
			if (a.getId() > id) {
				id = a.getId();
			}
		}
		return id;
	}

	@Override
	public User createUser(User user) {
		setId();
		user.setId(id);
		return user;
	}

	@Override
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "Successfully deleted user";
	}

	@Override
	public Optional<User> findUserByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public User updateUser(Long id, User user) {
		return repo.save(util.updateUser(repo.findById(id).get(), user));
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User createCV(Long id, Binary CV) {
		repo.findById(id).get().setCVObject(rest.createCV(CV));
		return repo.findById(id).get();
	}

}
