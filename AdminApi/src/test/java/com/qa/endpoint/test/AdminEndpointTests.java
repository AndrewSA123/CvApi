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
import com.qa.persistence.domain.Admin;
import com.qa.persistence.repository.IMongoRepository;
import com.qa.rest.AdminEndpoint;
import com.qa.service.IAdminService;


public class AdminEndpointTests {
	
	@InjectMocks
	private AdminEndpoint endpoint;
	@Mock
	private IAdminService service;
	@Mock
	private IMongoRepository repo;

	private Admin MockAdmin;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockAdmin = new Admin();
	}

	@After
	public void tearDown() {
		MockAdmin = null;
	}

	@Test
	public void testGetAllAdmins() {
		ArrayList<Admin> admins = new ArrayList<Admin>();
		admins.add(MockAdmin);
		Mockito.when(service.getAllAdmins()).thenReturn(admins);
		Assert.assertEquals(admins, endpoint.getAllAdmins());
	}

	@Test
	public void testGetAdmin() {
		Mockito.when(service.getAdmin(MockAdmin.getId())).thenReturn(Optional.of(MockAdmin));
		Assert.assertEquals(Optional.ofNullable(MockAdmin), endpoint.getAdmin(MockAdmin.getId()));
	}

	@Test
	public void testCreateAdmin() {
		Mockito.when(service.createAdmin(MockAdmin.getId(),MockAdmin)).thenReturn(MockAdmin);
		Assert.assertEquals(MockAdmin, endpoint.createAdmin(MockAdmin.getId(),MockAdmin));
	}

	@Test
	public void testDeleteAdmin() {
		Mockito.when(service.deleteAdmin(MockAdmin.getId())).thenReturn(MockConstants.MOCK_STRING);
		Assert.assertEquals(MockConstants.MOCK_STRING, endpoint.deleteAdmin(MockAdmin.getId()));
	}

	@Test
	public void testUpdateAdmin() {
		Mockito.when(service.updateAdmin(MockAdmin.getId(), MockAdmin)).thenReturn(MockAdmin);
		Assert.assertEquals(MockAdmin, endpoint.updateAdmin(MockAdmin.getId(), MockAdmin));
	}

}
