package com.qa.constantsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.qa.constants.CommentConstants;

public class CommentConstantTest {

	@InjectMocks
	private CommentConstants commentconst;

	@Test
	public void testCreate() {
		assertEquals("Comment created", commentconst.create);
	}

	@Test
	public void testUpdate() {
		assertEquals("Comment updated", commentconst.update);
	}

	@Test
	public void testDelete() {
		assertEquals("Comment deleted", commentconst.delete);
	}

}
