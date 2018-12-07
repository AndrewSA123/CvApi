package com.qa.endpoint.test;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.mockconstants.MockConstants;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.IMongoRepository;
import com.qa.rest.UserEndpoint;
import com.qa.service.IUserService;

public class UserEndpointTests {
	
	@InjectMocks
	private UserEndpoint endpoint;
	@Mock
	private IUserService service;
	@Mock
	private IMongoRepository repo;

	private User MockUser;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockUser = new User();
	}

	@After
	public void tearDown() {
		MockUser = null;
	}

	@Test
	public void testGetAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		users.add(MockUser);
		Mockito.when(service.getAllUsers()).thenReturn(users);
		Assert.assertEquals(users, endpoint.getAllUsers());
	}

	@Test
	public void testFindUserByID() {
		Mockito.when(service.findUserByID(MockUser.getId())).thenReturn(Optional.of(MockUser));
		Assert.assertEquals(Optional.ofNullable(MockUser), endpoint.findUserByID(MockUser.getId()));
	}

	@Test
	public void testCreateUser() {
		Mockito.when(service.createUser(MockUser)).thenReturn(MockUser);
		Assert.assertEquals(MockUser, endpoint.createUser(MockUser));
	}

	@Test
	public void testDeleteUser() {
		Mockito.when(service.deleteUser(MockUser.getId())).thenReturn(MockConstants.MOCK_STRING);
		Assert.assertEquals(MockConstants.MOCK_STRING, endpoint.deleteUser(MockUser.getId()));
	}

	@Test
	public void testUpdateUser() {
		Mockito.when(service.updateUser(MockUser.getId(), MockUser)).thenReturn(MockUser);
		Assert.assertEquals(MockUser, endpoint.updateUser(MockUser.getId(), MockUser));
	}

}
