package com.qa.service;

import java.util.Optional;

import com.qa.persistence.domain.User;

public interface IUserService {

	public String createUser(User user);

	public String deleteUser(Long id);

	public Optional<User> findUserByID(Long id);

	public String updateUser(Long id, User user);

	public Iterable<User> getAllUsers();

}
