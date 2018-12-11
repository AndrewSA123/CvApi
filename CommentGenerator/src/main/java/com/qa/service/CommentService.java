package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.CommentConstants;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.IMySqlRepository;
@Service
public class CommentService implements ICommentService{
	
	@Autowired
	private IMySqlRepository repo;
	
	private Comment temp;
	
	@Override
	public String createComment(Comment comment) {
		repo.save(comment);
		return CommentConstants.create;
	}

	@Override
	public String deleteComment(Long id) {
		repo.deleteById(id);
		return CommentConstants.delete;
	}

	@Override
	public String updateComment(Long id, Comment comment) {
		temp = repo.findById(id).get();
		temp = comment;
		repo.save(temp);
		return CommentConstants.update;
	}

	@Override
	public Iterable<Comment> getAll() {
		return repo.findAll();
	}

	@Override
	public Comment getComment(Long id) {
		return repo.findById(id).get();
	}

}
