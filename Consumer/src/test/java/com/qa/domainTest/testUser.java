package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.qa.persistence.domain.User;

public class testUser {

	@Mock
	private User user;
	
	@Before
	public void setup() {
		user = new User("gcliff", "password", "Gareth", "Clifford", "g.cliff@qa.com");
	}
	
	@After
	public void tearDown() {
		user = null;
	}
	
	@Test
	public void testGetEmail() {
		assertEquals(user.getEmail(),"g.cliff@qa.com");
	}
	
	@Test
	public void testGetUserName() {
		assertEquals(user.getUsername(),"gcliff");
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals(user.getFirstName(),"Gareth");
	}
	
	@Test
	public void testGetLastName() {
		assertEquals(user.getLastName(),"Clifford");
	}
	
	@Test
	public void testSetRole() {
		user.setRole("User");
		assertEquals(user.getRole(), "User");
	}
	
	@Test
	public void testSetEnabledTrue() {
		user.setEnabled(true);
		assertEquals(user.isEnabled(), true);
	}
	
	@Test
	public void testSetEnabledFalse() {
		user.setEnabled(false);
		assertEquals(user.isEnabled(), false);
	}
	
	@Test
	public void testSetUserID() {
		user.setUser_id(5L);
		assertEquals(user.getUser_id().toString(), "5");
	}
	
	@Test
	public void testSetEmail() {
		user.setEmail("Tadas@CV.com");
		assertEquals(user.getEmail(), "Tadas@CV.com");
	}
	
	@Test
	public void testSetUserName() {
		user.setUsername("TadasQA");
		assertEquals(user.getUsername(), "TadasQA");
	}
	
	@Test
	public void testSetPassword() {
		user.setPassword("password");
		assertEquals(user.getPassword(), "password");
	}
	
	@Test
	public void testSetFlaggedTrue() {
		user.setFlagged(true);
		assertEquals(user.isFlagged(), true);
	}
	
	@Test
	public void testSetFlaggedFalse() {
		user.setFlagged(false);
		assertEquals(user.isFlagged(), false);
	}
	
	@Test
	public void testSetFirstName() {
		user.setFirstName("Tadas");
		assertEquals(user.getFirstName(), "Tadas");
	}
	
	@Test
	public void testLastName() {
		user.setLastName("QAC");
		assertEquals(user.getLastName(), "QAC");
	}
}
