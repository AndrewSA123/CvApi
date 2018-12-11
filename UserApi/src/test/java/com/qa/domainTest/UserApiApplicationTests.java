package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.persistence.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiApplicationTests {

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
	
}
