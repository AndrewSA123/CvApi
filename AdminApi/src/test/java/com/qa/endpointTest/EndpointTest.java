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

import com.qa.constants.AdminConstants;
import com.qa.mockConstants.MockConstants;
import com.qa.persistence.domain.Admin;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.rest.AdminEndpoint;
import com.qa.service.IAdminService;

public class EndpointTest {

	@InjectMocks
	private AdminEndpoint endpoint;
	@Mock
	private IAdminService service;
	@Mock
	private IMySqlRepository repo;

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
		Mockito.when(endpoint.getAllAdmins()).thenReturn(admins);
		Assert.assertEquals(admins, endpoint.getAllAdmins());
	}

	@Test
	public void testGetAdmin() {
		Mockito.when(endpoint.getAdmin(MockAdmin.getAdmin_id())).thenReturn(Optional.of(MockAdmin));
		Assert.assertEquals(Optional.ofNullable(MockAdmin), endpoint.getAdmin(MockAdmin.getAdmin_id()));
	}

	@Test
	public void testCreateAdmin() {
		Mockito.when(endpoint.createAdmin(MockAdmin.getAdmin_id(),MockAdmin)).thenReturn(AdminConstants.create);
		Assert.assertEquals(AdminConstants.create, endpoint.createAdmin(MockAdmin.getAdmin_id(),MockAdmin));
	}

	@Test
	public void testDeleteAdmin() {
		Mockito.when(endpoint.deleteAdmin(MockAdmin.getAdmin_id())).thenReturn(MockConstants.MOCK_STRING);
		Assert.assertEquals(MockConstants.MOCK_STRING, endpoint.deleteAdmin(MockAdmin.getAdmin_id()));
	}
	
	
	@Test
	public void testUpdateAdmin() {
		Mockito.when(endpoint.updateAdmin(MockAdmin.getAdmin_id(), MockAdmin)).thenReturn(AdminConstants.update);
		Assert.assertEquals(AdminConstants.update, endpoint.updateAdmin(MockAdmin.getAdmin_id(), MockAdmin));
	}
}
