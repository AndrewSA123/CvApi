package com.qa.ConstantTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.qa.constants.UserConstants;
import com.qa.mockConstants.MockConstants;

public class ConstantTest {

	@InjectMocks
	UserConstants userconst;
	MockConstants mockconst;
	
	@Test
	public void testCommentSet() {
		assertEquals("Comment Set", userconst.CommentSet);
	}
	
	@Test
	public void testCommentNotFound() {
		assertEquals("CV not found", userconst.CommentNotFound);
	}
	
	@Test
	public void testCvUrl() {
		assertEquals("http://localhost:8082/cvgenerator/create", userconst.CvUrl);
	}
	
	@Test
	public void testUserDeleted() {
		assertEquals("User successfully deleted", userconst.userDeleted);
	}
	
	@Test
	public void testCreate() {
		assertEquals("User successfully created", userconst.create);
	}
	
	@Test
	public void testUpdate() {
		assertEquals("User updated!", userconst.update);
	}
}

