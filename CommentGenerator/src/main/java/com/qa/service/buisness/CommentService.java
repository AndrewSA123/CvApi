package com.qa.service.buisness;

public interface CommentService {

	String transferComment(Long adminId, Long userId, Long cvId, String comment);

}
