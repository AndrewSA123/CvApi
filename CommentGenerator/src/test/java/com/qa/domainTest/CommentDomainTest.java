package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.qa.persistence.domain.Comment;

public class CommentDomainTest {
	@Mock
	private Comment comment;

	@Before
	public void setup() {
		comment = new Comment(1L, 2L, "Very good CV", 1L);
	}

	@After
	public void tearDown() {
		comment = null;
	}

	@Test
	public void testgetUserID() {
		assertEquals(comment.getUser_id().toString(), "2");
	}

	@Test
	public void testgetAdminID() {
		assertEquals(comment.getAdmin_id().toString(), "1");
	}

	@Test
	public void testgetCVID() {
		assertEquals(comment.getCv_id().toString(), "1");
	}

	@Test
	public void testGetComment() {
		assertEquals(comment.getComment(), "Very good CV");
	}
	
	@Test
	public void testSetAdminId() {
		comment.setAdmin_id(5L);
		assertEquals(comment.getAdmin_id().toString(), "5");
	}
	
	@Test
	public void testSetUSerId() {
		comment.setUser_id(10L);
		assertEquals(comment.getUser_id().toString(), "10");
	}
	
	@Test
	public void testSetCVId() {
		comment.setCv_id(7L);
		assertEquals(comment.getCv_id().toString(), "7");
	}
	
	@Test
	public void testSetComment() {
		comment.setComment("Good");
		assertEquals(comment.getComment().toString(), "Good");
	}
	
	@Test
	public void testSetCommentID() {
		comment.setComment_id(123L);
		assertEquals(comment.getComment_id().toString(), "123");
	}
	
}
