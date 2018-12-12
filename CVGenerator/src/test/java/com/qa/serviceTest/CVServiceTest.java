package com.qa.serviceTest;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import com.qa.mockConstants.CVConstants;
import com.qa.persistence.domain.CV;
import com.qa.service.ICvService;

public class CVServiceTest {

	@Mock
	private ICvService service;

	private CV MockCv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockCv = new CV();
	
	}

	@After
	public void tearDown() {
		MockCv = null;
	}

	@Test
	public void testGetAllCV() {
		ArrayList<CV> users = new ArrayList<CV>();
		users.add(MockCv);
		Mockito.when(service.getall()).thenReturn(users);
		Assert.assertEquals(users, service.getall());
	}

	@Test
	public void testCreateCV() throws IOException {
		MultipartFile file = null;
		Mockito.when(service.createCv(1L, file)).thenReturn(CVConstants.CREATE_ACCOUNT);
		Assert.assertEquals(CVConstants.CREATE_ACCOUNT, service.createCv(1L, file));
	}

	@Test
	public void testDeleteUser() {
		Mockito.when(service.deleteCv(MockCv.getUser_id())).thenReturn(CVConstants.DELETE_ACCOUNT);
		Assert.assertEquals(CVConstants.DELETE_ACCOUNT, service.deleteCv(MockCv.getUser_id()));
	}

	@Test
	public void testUpdateUser() throws IOException {
		MultipartFile file = null;
		Mockito.when(service.updateCv(1L, file)).thenReturn(CVConstants.UPDATE_ACCOUNT);
		Assert.assertEquals(CVConstants.UPDATE_ACCOUNT, service.updateCv(1L, file));
	}

}