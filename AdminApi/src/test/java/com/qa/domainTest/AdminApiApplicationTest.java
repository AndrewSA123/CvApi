package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.qa.persistence.domain.Admin;

public class AdminApiApplicationTest {

	@Mock
	private Admin admin;
	
	@Before
	public void setup() {
		admin = new Admin("gcliff", "password", "Gareth", "Clifford", "g.cliff@qa.com", true);
	}
	
	@After
	public void tearDown() {
		admin = null;
	}
	
	@Test
	public void testGetEmail() {
		assertEquals(admin.getEmail(),"g.cliff@qa.com");
	}
	
	@Test
	public void testGetUserName() {
		assertEquals(admin.getUsername(),"gcliff");
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals(admin.getFirstName(),"Gareth");
	}
	
	@Test
	public void testGetLastName() {
		assertEquals(admin.getLastName(),"Clifford");
	}
	
	@Test 
	public void testIsSuperAdmin() {
		assertEquals(admin.isSuperAdmin(), true);
	}
	
}
