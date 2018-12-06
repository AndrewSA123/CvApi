package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Comment;
import com.qa.util.CommentsProducer;

@CrossOrigin
@RequestMapping("${URL.base.comment}")
@RestController
public class CommentsEndpoints {

	@Autowired
	private CommentsProducer commentProd;

	@PostMapping("${URL.method.addComment}")
	public String addComment(@PathVariable("adminId") Long adminId, @RequestBody Comment comment) {
		return commentProd.produce(adminId, comment);
	}

}
