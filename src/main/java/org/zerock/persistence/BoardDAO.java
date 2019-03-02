package org.zerock.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.VisitorVO;

@Repository
public interface BoardDAO {

	public void create (BoardVO vo ) throws Exception;
	
	public  BoardVO read (Integer bno) throws Exception;
	
	public void update (BoardVO vo) throws Exception;
	
	public void delete (Integer bno) throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<VisitorVO> allVisitor() throws Exception;
	
	public List<Historic_siteVO> topHistoric() throws Exception;
	
	public List<Historic_site_starVO> userStar() throws Exception;
	
}
