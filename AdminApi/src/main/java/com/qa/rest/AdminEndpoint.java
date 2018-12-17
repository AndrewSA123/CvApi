package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qa.persistence.domain.Admin;
import com.qa.service.IAdminService;
@RestController
@CrossOrigin
@RequestMapping("${endpoint.base}")
public class AdminEndpoint implements IAdminEndpoint{

	@Autowired
	private IAdminService service;
	
	@Override
	@PostMapping("${endpoint.create}")
	public String createAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
		return service.createAdmin(id, admin);
	}

	@Override
	@DeleteMapping("${endpoint.delete}")
	public String deleteAdmin(@PathVariable("id") Long id) {
		return service.deleteAdmin(id);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public String updateAdmin(@PathVariable("admin_id") Long admin_id, @RequestBody Admin newAdmin) {
		return service.updateAdmin(admin_id, newAdmin);
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
	@GetMapping("${endpoint.getemail}")
	public String getEmail(@PathVariable("id") Long id){ return service.getEmail(id); }

}
