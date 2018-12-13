package com.qa.testService;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.constants.ConsumerConstants;
import com.qa.persistence.domain.Admin;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.domain.User;
import com.qa.service.ServiceLayer;

public class ServiceTest {

	@Mock
	private User user;

	@Mock
	private ServiceLayer service;

	private String users; 
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		user = new User();
		String users = user.toString();
	}

	@After
	public void tearDown() {
		user = null;
	}
	
	@Test
	public void testCreateUser() {
		Mockito.when(service.createString(users)).thenReturn(ConsumerConstants.create);
		Assert.assertEquals(ConsumerConstants.create, service.createString(users));
	}


}
