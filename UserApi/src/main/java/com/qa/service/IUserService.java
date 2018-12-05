package com.qa.service;

import java.util.Optional;

import com.qa.peristence.domain.Users;

public interface IUserService {

	String createUser(String userName, String password, String email, String address, String firstName, String secondName);

	Iterable<Users> getAllUsers();

	String deleteUser(Long id);

	Optional<Users> getUserById(Long id);



}
