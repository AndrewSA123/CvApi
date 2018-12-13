package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.CommentConstants;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.service.producer.Producer;
@Service
public class CommentService implements ICommentService{
	
	@Autowired
	private IMySqlRepository repo;
	
	private Comment temp;
	
	@Autowired
	private Producer producer;
	
	@Override
	public String createComment(Comment comment) {
		producer.persistComment(comment);
		repo.save(comment);
		return CommentConstants.create;
	}

	@Override
	public String deleteComment(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return CommentConstants.delete;
		}
		return CommentConstants.fail;
	}

	@Override
	public String updateComment(Long id, Comment comment) {
		if(repo.findById(id).isPresent()) {
			temp = repo.findById(id).get();
			temp = comment;
			repo.save(temp);
			return CommentConstants.update;
		}
		return CommentConstants.fail;
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
