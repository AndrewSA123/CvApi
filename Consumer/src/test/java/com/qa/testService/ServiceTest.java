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
	private Admin admin;
	@Mock
	private User user;
	@Mock
	private CV cv;
	@Mock
	private Comment comment;
	@Mock
	private ServiceLayer service;
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		user = new User();
		comment = new Comment();
		cv = new CV();
		admin = new Admin();
	}

	@After
	public void tearDown() {
		user = null;
		admin = null;
		cv = null;
		comment = null;
	}
	
	
	@Test
	public void testCreateUser() {
		Mockito.when(service.createUser(user)).thenReturn(ConsumerConstants.create);
		Assert.assertEquals(ConsumerConstants.create, service.createUser(user));
	}
	
	@Test
	public void testCreateCV() {
		Mockito.when(service.createCv(cv)).thenReturn(ConsumerConstants.create);
		Assert.assertEquals(ConsumerConstants.create, service.createCv(cv));
	}
	
	@Test
	public void testCreateComment() {
		Mockito.when(service.createComment(comment)).thenReturn(ConsumerConstants.create);
		Assert.assertEquals(ConsumerConstants.create, service.createComment(comment));
	}
	
	@Test
	public void testCreateAdmin() {
		Mockito.when(service.createAdmin(admin)).thenReturn(ConsumerConstants.create);
		Assert.assertEquals(ConsumerConstants.create, service.createAdmin(admin));
	}

}
