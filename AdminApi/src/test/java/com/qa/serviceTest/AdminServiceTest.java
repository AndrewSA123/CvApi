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

import com.qa.constants.AdminConstants;
import com.qa.mockConstants.MockConstants;
import com.qa.persistence.domain.Admin;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.service.AdminService;

public class AdminServiceTest {
	
	@Mock
	private AdminService service;
	@Mock
	private IMySqlRepository repo;
	@Mock
	private Admin user;
	
	private Admin MockAdmin;
	private Admin SuperAdmin;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockAdmin = new Admin();
		SuperAdmin = new Admin("","","","","",true);
	}
	
	@After
	public void tearDown() {
		MockAdmin = null;
		SuperAdmin = null;
	}
	 
	@Test
	public void testCreateAdmin() {
		repo.save(MockAdmin);
		repo.save(SuperAdmin);
		Mockito.when(service.createAdmin(SuperAdmin.getAdmin_id(), MockAdmin)).thenReturn(AdminConstants.create);
		Assert.assertEquals(AdminConstants.create,service.createAdmin(MockAdmin.getAdmin_id(),MockAdmin));
		
	}
	
	@Test
	public void testDeleteAdmin() {
		
		Mockito.when(service.deleteAdmin(MockAdmin.getAdmin_id())).thenReturn(AdminConstants.delete);
		Assert.assertEquals(AdminConstants.delete,service.deleteAdmin(MockAdmin.getAdmin_id()));
	}
	
	@Test
	public void testGetAdmin() {
		Mockito.when(service.getAdmin(MockAdmin.getAdmin_id())).thenReturn(Optional.ofNullable(MockAdmin));
		Assert.assertEquals(Optional.ofNullable(MockAdmin), service.getAdmin(MockAdmin.getAdmin_id()));
		
	}
	
	@Test
	public void testGetAllAdmins() {
		ArrayList<Admin> userList = new ArrayList<Admin>();
		userList.add(MockAdmin);
		Mockito.when(service.getAllAdmins()).thenReturn(userList);
		Assert.assertEquals(userList, service.getAllAdmins());
	}
	 
	@Test
	public void testUpdateAdmin() {
		service.createAdmin(SuperAdmin.getAdmin_id(), MockAdmin);
		Mockito.when(service.updateAdmin(MockAdmin.getAdmin_id(), SuperAdmin)).thenReturn(MockConstants.UPDATE_ACCOUNT);
		Assert.assertEquals(MockConstants.UPDATE_ACCOUNT, service.updateAdmin(MockAdmin.getAdmin_id(), SuperAdmin));
		
	}


}
