package com.qa.serviceTest;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.constants.UserConstants;
import com.qa.persistence.domain.User;
import com.qa.service.IUserService;

public class UserServiceTest {

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
		Assert.assertEquals(users, service.getAllUsers());
	}

	@Test
	public void testFindUserByID() {
		Mockito.when(service.findUserByID(MockUser.getUser_id())).thenReturn(Optional.of(MockUser));
		Assert.assertEquals(Optional.ofNullable(MockUser), service.findUserByID(MockUser.getUser_id()));
	}

	@Test
	public void testCreateUser() {
		Mockito.when(service.createUser(MockUser)).thenReturn(UserConstants.create);
		Assert.assertEquals(UserConstants.create, service.createUser(MockUser));
	}

	@Test
	public void testDeleteUser() {
		Mockito.when(service.deleteUser(MockUser.getUser_id())).thenReturn(UserConstants.userDeleted);
		Assert.assertEquals(UserConstants.userDeleted, service.deleteUser(MockUser.getUser_id()));
	}

	@Test
	public void testUpdateUser() {
		Mockito.when(service.updateUser(MockUser.getUser_id(), MockUser)).thenReturn(UserConstants.update);
		Assert.assertEquals(UserConstants.update, service.updateUser(MockUser.getUser_id(), MockUser));
	}

}