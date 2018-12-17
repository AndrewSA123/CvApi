package com.qa.service;

import java.util.Optional;

import com.qa.persistence.domain.User;

public interface IUserService {

	public String createUser(User user);

	public String deleteUser(Long id);

	public Optional<User> findUserByID(Long id);

	public String updateUser(Long id, User user);

	public Iterable<User> getAllUsers();

	String tagUser(Long uId, Long aId);

    String untagUser(Long uId, Long aId);

	String getTags(Long id);

    String getUsername(Long id);

}
