package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Admin;
import com.qa.service.IAdminService;
@RestController
@RequestMapping("${endpoint.base}")
public class AdminEndpoint implements IAdminEndpoint{

	@Autowired
	private IAdminService service;
	
	@Override
	@PostMapping("${endpoint.create}")
	public Admin createAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
		return service.createAdmin(id, admin);
	}

	@Override
	@DeleteMapping("${endpoint.delete}")
	public String deleteAdmin(@PathVariable("id") Long id) {
		return service.deleteAdmin(id);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public Admin updateAdmin(@PathVariable("id") Long id, @RequestBody Admin newAdmin) {
		return service.updateAdmin(id, newAdmin);
	}

	@Override
	@GetMapping("${endpoint.getall}")
	public Iterable<Admin> getAllAdmins() {
		return service.getAllAdmins();
	}

	@Override
	@GetMapping("${endpoint.get}")
	public Optional<Admin> getAdmin(@PathVariable("id") Long id) {
		return service.getAdmin(id);
	}

	@Override
	@PostMapping("${endpoint.createcomment}")
	public String createComment(@PathVariable("id") Long id, @RequestBody String comment) {
		return service.createComment(id, comment);
	}

}
