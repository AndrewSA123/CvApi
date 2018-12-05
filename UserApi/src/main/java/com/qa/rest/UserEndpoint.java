package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.peristence.domain.Users;
import com.qa.service.IUserService;

@RestController
@RequestMapping("${endpoint.base}")
@CrossOrigin
public class UserEndpoint {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("${endpoint.getbyid}")
	public Optional<Users> getUserById(@PathVariable("id") Long id) {
		return service.getUserById(id);
	}
	
	@GetMapping("${endpoint.getall}")
	public Iterable<Users> getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping("${endpoint.create}")
	public String createUser(@RequestBody String username, String password, String email, String firstName, String secondName, String address) {
		return service.createUser(username, password, email, firstName, secondName, address);
	}

	@DeleteMapping("${endpoint.delete}")
	public String deleteUser(@PathVariable("id") Long id) {
		return service.deleteUser(id);
	}

}
