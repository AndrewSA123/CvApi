package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.buisness.CommentService;

@CrossOrigin
@RequestMapping("${URL.base.comment}")
@RestController
public class CommentEndpoint {

	@Autowired
	private CommentService service;

	@PostMapping("${URL.method.transferComment}")
	public String transferComment(@PathVariable("adminId") Long adminId, @PathVariable("userId") Long userId,
			@PathVariable("cvId") Long cvId, @RequestBody String comment) {
		return service.transferComment(adminId, userId, cvId, comment);
	}

}
