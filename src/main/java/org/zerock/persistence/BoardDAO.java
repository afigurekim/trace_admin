package org.zerock.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.EditorReplyVO;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_detailVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.ReplyVO;
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
	
	public List<Historic_siteVO> allHistoric() throws Exception;
	
	public String selectThema(int bno) throws Exception;
	
	public String selectPeriod(int bno)throws Exception;

	public void updateCategory(String period,String thema,int bno)throws Exception;
	
	public List<Historic_site_detailVO> allDetail()throws Exception;
	
	public void updatePeriod(int bno,String period)throws Exception;
	
	public void updateThema(int bno,String thema)throws Exception;
	
	
	//댓글 관리
	public List<ReplyVO> historic_replylist()throws Exception;
	
	public void deleteReply(int rno) throws Exception;
	
	public List<EditorReplyVO> editor_replylist()throws Exception;
	
	public void deleteEditReply(int rno)throws Exception;
	
	
}
