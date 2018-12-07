package com.qa.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.mockconstants.MockConstants;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.IMongoRepository;
import com.qa.service.UserService;

public class ServiceTests {
	
	@InjectMocks
	private UserService service;
	@Mock
	private IMongoRepository repo;
	@Mock
	private User user;
	
	private User MockUser;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockUser = new User();
	}
	
	@Test
	public void testCreateUser() {
		Mockito.when(repo.save(MockUser)).thenReturn(MockUser);
		Assert.assertEquals(MockUser,service.createUser(MockUser));
	}
	
	@Test
	public void testDeleteUser() {
		Mockito.when(repo.findById(MockUser.getId())).thenReturn(Optional.of(MockUser));
		Assert.assertEquals(MockConstants.DELETE_ACCOUNT,service.deleteUser(MockUser.getId()));
	}
	
	@Test
	public void testFindUserByID() {
		Mockito.when(repo.findById(MockUser.getId())).thenReturn(Optional.of(MockUser));
		Assert.assertEquals(Optional.ofNullable(MockUser), service.findUserByID(MockUser.getId()));
		
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> userList = new ArrayList<User>();
		userList.add(MockUser);
		Mockito.when(repo.findAll()).thenReturn(userList);
		Assert.assertEquals(userList, service.getAllUsers());
	}
	 
	@Test
	@Ignore
	public void testUpdateUser() {
		Mockito.when(repo.findById(MockUser.getId())).thenReturn(Optional.of(MockUser));
		Assert.assertEquals(MockConstants.UPDATE_ACCOUNT, service.updateUser(MockUser.getId(), MockUser));
		
	}

}
