package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.util.CommentsProducer;

@CrossOrigin
@RequestMapping("${URL.base.comment}")
@RestController
public class CommentsEndpoints {

	@Autowired
	private CommentsProducer commentProd;

	@PostMapping("${URL.method.addComment}")
	public String addAdminAccount(@PathVariable("adminId") Long adminId, @PathVariable("userId") Long userId,
			@PathVariable("cvId") Long cvId, @PathVariable("comment") String comment) {
		return commentProd.produce(adminId, userId, cvId, comment);
	}

}
