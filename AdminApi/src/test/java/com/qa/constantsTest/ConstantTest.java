package com.qa.constantsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.qa.constants.AdminConstants;
import com.qa.mockConstants.MockConstants;

public class ConstantTest {

	@InjectMocks
	AdminConstants adminconst;
	MockConstants mockconst;
	

	@Test
	public void testCreate() {
		assertEquals("Admin successfully created", adminconst.create);
	}
	
	@Test
	public void testUpdate() {
		assertEquals("Admin updated", adminconst.update);
	}
	
	@Test
	public void testDelete() {
		assertEquals("Admin successfully deleted", adminconst.delete);
	}
	
	@Test
	public void testFail() {
		assertEquals("Something went wrong", adminconst.fail);
	}
	
}

