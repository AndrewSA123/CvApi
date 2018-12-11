package com.qa.endpointTest;

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

import com.qa.mockConstants.MockConstants;
import com.qa.persistence.domain.User;
import com.qa.rest.UserEndpoint;
import com.qa.service.IUserService;

public class EndpointTest {
	
	@InjectMocks
	private UserEndpoint endpoint;
	@Mock
	private IUserService service;

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
		Mockito.when(service.findUserByID(MockUser.getUser_id())).thenReturn(Optional.of(MockUser));
		Assert.assertEquals(Optional.ofNullable(MockUser), endpoint.findUserByID(MockUser.getUser_id()));
	}

	@Test
	public void testCreateUser() {
		Mockito.when(endpoint.createUser(MockUser)).thenReturn(MockConstants.CREATE_ACCOUNT);
		Assert.assertEquals(MockConstants.CREATE_ACCOUNT, endpoint.createUser(MockUser));
	}

	@Test
	public void testDeleteUser() {
		Mockito.when(service.deleteUser(MockUser.getUser_id())).thenReturn(MockConstants.DELETE_ACCOUNT);
		Assert.assertEquals(MockConstants.DELETE_ACCOUNT, endpoint.deleteUser(MockUser.getUser_id()));
	}

	@Test
	public void testUpdateUser() {
		Mockito.when(endpoint.updateUser(MockUser.getUser_id(), MockUser)).thenReturn(MockConstants.UPDATE_ACCOUNT);
		Assert.assertEquals(MockConstants.UPDATE_ACCOUNT, endpoint.updateUser(MockUser.getUser_id(), MockUser));
	}

}