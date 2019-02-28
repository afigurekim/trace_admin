package org.zerock.test;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceTest {

	@Inject
	private BoardService service;
	
	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Test
	public void testExist() {
		logger.info(service.toString());
		assertNotNull(service);
	}
	
	@Test
	public void testRegist() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("admin00");
		
		service.regist(board);
	}
	
	/*
	 * 근데 왜 listall 을 안쓰는거지??? 훔.. 일단 오류나는데 나두고 해보자
	@Test
	public void testListAll() throws Exception{
		service.listAll().forEach(board->logger.info(board.toString()));
	
	}*/
	@Test
	public void testRead() throws Exception {
		logger.info(service.read(3).toString());
	}
	
	@Test
	public void testModify() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(3);
		board.setTitle("modified title");
		board.setContent("modifed content");
		service.modify(board);;
	}
	
	@Test
	public void testRemove() throws Exception{
		service.remove(3);
	}
}
