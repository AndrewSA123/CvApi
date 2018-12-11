package com.qa.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.constants.CommentConstants;
import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.IMySqlRepository;
import com.qa.service.ICommentService;

public class CommentServiceTest {
	
	@Mock
	private ICommentService service;
	@Mock
	private IMySqlRepository repo;
	@Mock
	private Comment comment;
	@Mock
	private Comment comment2;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		comment = new Comment(1L,1L,"Good CV",1L);
		comment2 = new Comment(2L, 2L, "Bad CV", 1L);
	}
	
	@After
	public void tearDown() {
		comment = null;
	}
	
	@Test
	public void testDeleteComment() {
		Mockito.when(service.deleteComment(comment.getComment_id())).thenReturn(CommentConstants.delete);
		assertEquals(service.deleteComment(comment.getComment_id()), CommentConstants.delete);
	}
	
	@Test
	public void testCreateComment() {
		Mockito.when(service.createComment(comment)).thenReturn(CommentConstants.create);
		assertEquals(service.createComment(comment), CommentConstants.create);
	}
	
	@Test
	public void testUpdateComment() {
		Mockito.when(service.updateComment(comment.getComment_id(), comment2)).thenReturn(CommentConstants.update);
		assertEquals(service.updateComment(comment.getComment_id(), comment2), CommentConstants.update);
	}
	
	@Test
	public void testGetComment() {
		Mockito.when(service.getComment(comment.getComment_id())).thenReturn(comment);
		assertEquals(service.getComment(comment.getComment_id()), comment);
	}
	

}
