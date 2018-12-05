package com.qa.service;

import java.util.Optional;

import com.qa.peristence.domain.Users;

public interface IUserService {

	String createUser(Users username);

	Iterable<Users> getAllUsers();

	String deleteUser(Long id);

	Users updateUser(Long id, Users username);

	Optional<Users> getUserById(Long id);



}
