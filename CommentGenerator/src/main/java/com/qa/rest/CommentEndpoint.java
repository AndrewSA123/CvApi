package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qa.persistence.domain.Comment;
import com.qa.service.ICommentService;
@RestController
@CrossOrigin
@RequestMapping("${endpoint.base}")
public class CommentEndpoint implements ICommentEndpoint{

	@Autowired
	private ICommentService service;
	

	@Override
	@PostMapping("${endpoint.create}")
	public String createComment(@RequestBody Comment comment) {
		return service.createComment(comment);
	}

	@Override
	@DeleteMapping("${endpoint.delete}")
	public String deleteComment(@PathVariable("id")Long id) {
		return service.deleteComment(id);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public String updateComment(@PathVariable("id")Long id, @RequestBody Comment comment) {
		return service.updateComment(id, comment);
	}

	@Override
	@GetMapping("${endpoint.get}")
	public Comment getComment(@PathVariable("id") Long id) {
		return service.getComment(id);
	}

	@Override
	@GetMapping("${endpoint.getall}")
	public Iterable<Comment> getAll() {
		return service.getAll();
	}

}
