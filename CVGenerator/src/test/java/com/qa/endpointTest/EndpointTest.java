package com.qa.endpointTest;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import com.qa.mockConstants.CVConstants;
import com.qa.persistence.domain.CV;
import com.qa.rest.CvEndpoint;
import com.qa.service.ICvService;

public class EndpointTest {
	
	@InjectMocks
	private CvEndpoint endpoint;
	@Mock
	private ICvService service;

	private CV MockCV;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockCV = new CV();
	}

	@After
	public void tearDown() {
		MockCV = null;
	}

	@Test
	public void testGetAllUsers() {
		ArrayList<CV> cvs = new ArrayList<CV>();
		cvs.add(MockCV);
		Mockito.when(endpoint.getall()).thenReturn(cvs);
		Assert.assertEquals(cvs, endpoint.getall());
	}

	@Test
	@Ignore
	public void testCreateUser() throws IOException {
		MultipartFile file = null;
		Mockito.when(endpoint.createCv(1L, file)).thenReturn(CVConstants.CREATE_ACCOUNT);
		Assert.assertEquals(CVConstants.CREATE_ACCOUNT, endpoint.createCv(1L, file));
	}

	@Test
	public void testDeleteUser() {
		Mockito.when(endpoint.deleteCv(MockCV.getUser_id())).thenReturn(CVConstants.DELETE_ACCOUNT);
		Assert.assertEquals(CVConstants.DELETE_ACCOUNT, endpoint.deleteCv(MockCV.getUser_id()));
	}

	@Test
	public void testUpdateUser() throws IOException {
		MultipartFile file = null;
		Mockito.when(endpoint.updateCv(1L, file)).thenReturn(CVConstants.UPDATE_ACCOUNT);
		Assert.assertEquals(CVConstants.UPDATE_ACCOUNT, endpoint.updateCv(1L, file));
	}

}