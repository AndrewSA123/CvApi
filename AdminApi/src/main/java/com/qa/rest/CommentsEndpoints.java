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
public class CommentsEndpoints {

	@Autowired
	private CommentService service;

	@PostMapping("${URL.method.addComment}")
	public String addComment(@PathVariable("adminId") Long adminId, @PathVariable("userId") Long userId, @PathVariable("cvId") Long cvId, @RequestBody String comment) {
		return service.addComment(adminId, userId, cvId, comment);
	}

}
