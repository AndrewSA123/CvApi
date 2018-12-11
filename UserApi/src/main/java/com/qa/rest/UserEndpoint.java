package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.User;
import com.qa.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("${endpoint.base}")
public class UserEndpoint implements IUserEndpoint {

	@Autowired
	private IUserService service;

	@Override
	@PostMapping("${endpoint.create}")
	public String createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@Override
	@DeleteMapping("${endpoint.delete}")
	public String deleteUser(@PathVariable("id") Long id) {
		return service.deleteUser(id);
	}

	@Override
	@GetMapping("${endpoint.get}")
	public Optional<User> findUserByID(@PathVariable("id") Long id) {
		return service.findUserByID(id);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@Override
	@GetMapping("${endpoint.getall}")
	public Iterable<User> getAllUsers() {
		return service.getAllUsers();
	}

}
