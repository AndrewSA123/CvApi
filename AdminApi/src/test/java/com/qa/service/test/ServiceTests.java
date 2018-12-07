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
import com.qa.persistence.domain.Admin;
import com.qa.persistence.repository.IMongoRepository;
import com.qa.service.AdminService;

public class ServiceTests {
	
	@InjectMocks
	private AdminService service;
	@Mock
	private IMongoRepository repo;
	@Mock
	private Admin user;
	
	private Admin MockAdmin;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockAdmin = new Admin();
	}
	
	@Test
	@Ignore
	public void testCreateAdmin() {
//		Mockito.when(repo.findById(MockAdmin.getId())).thenReturn(Optional.of(MockAdmin));
		Mockito.when(repo.save(MockAdmin)).thenReturn(MockAdmin);
		Assert.assertEquals(MockAdmin,service.createAdmin(MockAdmin.getId(),MockAdmin));
	}
	
	@Test
	public void testDeleteAdmin() {
		Mockito.when(repo.findById(MockAdmin.getId())).thenReturn(Optional.of(MockAdmin));
		Assert.assertEquals(MockConstants.DELETE_ACCOUNT,service.deleteAdmin(MockAdmin.getId()));
	}
	
	@Test
	public void testGetAdmin() {
		Mockito.when(repo.findById(MockAdmin.getId())).thenReturn(Optional.of(MockAdmin));
		Assert.assertEquals(Optional.ofNullable(MockAdmin), service.getAdmin(MockAdmin.getId()));
		
	}
	
	@Test
	public void testGetAllAdmins() {
		List<Admin> userList = new ArrayList<Admin>();
		userList.add(MockAdmin);
		Mockito.when(repo.findAll()).thenReturn(userList);
		Assert.assertEquals(userList, service.getAllAdmins());
	}
	 
	@Test
	@Ignore
	public void testUpdateAdmin() {
		Mockito.when(repo.findById(MockAdmin.getId())).thenReturn(Optional.of(MockAdmin));
		Assert.assertEquals(MockConstants.UPDATE_ACCOUNT, service.updateAdmin(MockAdmin.getId(), MockAdmin));
		
	}

}
