package com.qa.service;

import java.util.Optional;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.UserConstants;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.Comment;
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

	private User foundUser;

	private Long setId() {
		temp = getAllUsers();
		for (User a : temp) {
			if (a.getId() > id) {
				id = a.getId();
			}
		}
		return id + 1;
	}

	@Override
	public User createUser(User user) {
		user.setId(setId());
		return repo.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return UserConstants.userDeleted;
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
		if (repo.findById(id).get().getCVList().size() < 3) {
			repo.findById(id).get().setCVObject(rest.createCV(id, CV));
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public User createComment(Comment comment) {

		for (User user : getAllUsers()) {
			for (CV cv : user.getCVList()) {
				if (cv.getId() == comment.getCVID() && user.getCVList() != null) {
					foundUser = repo.findById(user.getId()).get();
					foundUser.setCvComment(comment);
					return repo.save(foundUser);
				}
			}
		}
		return null;
	}

}
