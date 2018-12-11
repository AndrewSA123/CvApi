package com.qa.constantsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.qa.mockConstants.MockConstants;

public class MockConstantTest {
	
	@InjectMocks
	MockConstants mockconst;
	
	@Test
	public void testMOCK_STRING() {
		assertEquals("Success", mockconst.MOCK_STRING);
	}
	
	@Test
	public void testDELETE_ACCOUNT() {
		assertEquals("Successfully deleted admin", mockconst.DELETE_ACCOUNT);
	}
	
	@Test
	public void testUPDATE_ACCOUNT() {
		assertEquals("Successfully updated admin", mockconst.UPDATE_ACCOUNT);
	}

}
