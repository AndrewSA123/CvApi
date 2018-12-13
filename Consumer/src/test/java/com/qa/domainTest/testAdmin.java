package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.qa.persistence.domain.Admin;

public class testAdmin {


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
	public void testGetRole() {
		assertEquals(admin.getRole(),"Admin");
	}
	
	@Test
	public void testSetRole() {
		admin.setRole("Admin2");
		assertEquals(admin.getRole(),"Admin2");
	}
	
	@Test
	public void testIsEnabled() {
		assertEquals(admin.isEnabled(),true);
	}
	
	@Test
	public void testSetEnabledFalse() {
		admin.setEnabled(false);
		assertEquals(admin.isEnabled(),false);
	}
	
	@Test
	public void testSetEnabledTrue() {
		admin.setEnabled(true);
		assertEquals(admin.isEnabled(),true);
	}
	
	@Test
	public void testSetEmail() {
		admin.setEmail("tadas@qa.com");
		assertEquals(admin.getEmail(), "tadas@qa.com");
	}
	
	@Test
	public void testGetEmail() {
		assertEquals(admin.getEmail(),"g.cliff@qa.com");
	}
	
	@Test
	public void testSettAdminID() {
		admin.setAdmin_id(6L);
		assertEquals(admin.getAdmin_id().toString(), "6");
	}
	
	@Test
	public void testGetUserName() {
		assertEquals(admin.getUsername(),"gcliff");
	}
	
	@Test
	public void setUsername() {
		admin.setUsername("tadas");
		assertEquals(admin.getUsername(), "tadas");
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals(admin.getFirstName(),"Gareth");
	}
	
	@Test
	public void setFirstName() {
		admin.setFirstName("tadas");
		assertEquals(admin.getFirstName(), "tadas");
	}
	
	@Test
	public void testGetLastName() {
		assertEquals(admin.getLastName(),"Clifford");
	}
	
	@Test
	public void setLastName() {
		admin.setLastName("qa");
		assertEquals(admin.getLastName(), "qa");
	}
	
	@Test 
	public void testIsSuperAdmin() {
		assertEquals(admin.isSuperAdmin(), true);
	}
}
