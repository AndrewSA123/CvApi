package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.persistence.domain.CV;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CVApiApplicationTests {

	@Mock
	private CV cv;

	@Before
	public void setup() throws IOException {
		byte[] cvs = null;
		cv = new CV(1L, "AndyCV", cvs);
	}

	@After
	public void tearDown() {
		cv = null;
	}

	@Test
	public void testGetFileName() {
		assertEquals(cv.getFileName(), "AndyCV");
	}

	@Test
	public void testGetContents() {
		byte[] cvs = null;
		assertEquals(cv.getContents(), cvs);
	}

	@Test
	public void testSetCVID() {
		cv.setCv_id(5L);
		assertEquals(cv.getCv_id().toString(), "5");
	}

	@Test
	public void testUserID() {
		assertEquals(cv.getUser_id().toString(), "1");
	}

	@Test
	public void testSetFileName() {
		cv.setFileName("Tadas CV");
		assertEquals(cv.getFileName(), "Tadas CV");
	}

	@Test
	public void testSetContents() {
		byte[] newCvs = null;
		cv.setContents(newCvs);
		assertEquals(cv.getContents(), newCvs);
	}

	@Test
	public void testSetUserID() {
		cv.setUser_id(10L);
		assertEquals(cv.getUser_id().toString(), "10");
	}

}
