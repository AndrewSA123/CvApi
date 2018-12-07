package com.qa.webservices;

public interface IConsumeComment {
	
	public String sendComment(Long admin_id, Long user_id, String comment);

}
