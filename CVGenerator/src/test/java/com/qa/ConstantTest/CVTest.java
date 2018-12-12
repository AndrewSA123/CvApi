package com.qa.ConstantTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.qa.mockConstants.CVConstants;

public class CVTest {

	@InjectMocks
	CVConstants cvconst;
	
	@Test
	public void testCommentSet() {
		assertEquals("CV Set", cvconst.CVSet);
	}
	
	@Test
	public void testCommentNotFound() {
		assertEquals("CV not found", cvconst.FAIL);
	}
	
	@Test
	public void testUserDeleted() {
		assertEquals("Successfully deleted CV", cvconst.DELETE_ACCOUNT);
	}
	
	@Test
	public void testCreate() {
		assertEquals("Successfully created CV", cvconst.CREATE_ACCOUNT);
	}
	
	@Test
	public void testUpdate() {
		assertEquals("Successfully updated CV", cvconst.UPDATE_ACCOUNT);
	}
}

