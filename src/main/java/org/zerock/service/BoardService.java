package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.VisitorVO;

public interface BoardService {

	public void regist(BoardVO board) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void modify(BoardVO board)throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<VisitorVO> allVisitor() throws Exception;

	public List<Historic_siteVO> topHistoric()throws Exception;
	
	public List<Historic_site_starVO> userStar() throws Exception;
	
}
