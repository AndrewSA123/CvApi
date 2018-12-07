package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Comment;
import com.qa.service.ICommentService;
@RestController
@RequestMapping("${endpoint.base}")
public class CommentEndpoint implements ICommentEndpoint{

	@Autowired
	private ICommentService service;
	
	@Override
	@PostMapping("${endpoint.create}")
	public Comment createComment(@PathVariable("admin_id")Long admin_id, @PathVariable("user_id")Long user_id, @RequestBody String comment) {
		return service.createComment(admin_id, user_id, comment);
	}

}
