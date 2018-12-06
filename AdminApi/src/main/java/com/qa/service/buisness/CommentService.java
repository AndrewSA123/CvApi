package com.qa.service.buisness;

public interface CommentService {
	
	String addComment(Long adminId, Long userId, Long cvId, String comment);

}
