package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.EditorReplyVO;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_detailVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.ReplyVO;
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
	
	public List<Historic_siteVO> allHistoric() throws Exception;
	
	public String selectPeriod(int bno) throws Exception;
	
	public String selectThema(int bno) throws Exception;
	
	public void updateCategory(String period,String thema,int bno);
	
	public List<Historic_site_detailVO> allDetail()throws Exception;
	
	public void updatePeriod(int bno,String period)throws Exception;
	
	public void updateThema(Historic_siteVO vo)throws Exception;
	
	
	//댓글관리
	public List<ReplyVO> historic_replylist() throws Exception;
	
	public void deleteReply(int rno)throws Exception;
	
	public List<EditorReplyVO> editor_replylist() throws Exception;
	
	public void deleteEditReply(int rno)throws Exception;
	
	
	
}
