package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.EditorReplyVO;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_detailVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.VisitorVO;
import org.zerock.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	//insert
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
		
	}

	@Override
	//select �ϳ��� �Խñ�
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	//update
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
		
	}

	@Override
	//delete
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
		
	}

	@Override
	//�Խñ� ��ü �ҷ����� 
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<VisitorVO> allVisitor() throws Exception {
		// TODO Auto-generated method stub
		return dao.allVisitor();
	}

	@Override
	public List<Historic_siteVO> topHistoric() throws Exception {
		// TODO Auto-generated method stub
		return dao.topHistoric();
	}

	@Override
	public List<Historic_site_starVO> userStar() throws Exception {
		// TODO Auto-generated method stub
		return dao.userStar();
	}

	@Override
	public List<Historic_siteVO> allHistoric() throws Exception {
		// TODO Auto-generated method stub
		return dao.allHistoric();
	}

	@Override
	public String selectPeriod(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPeriod(bno);
	}

	@Override
	public String selectThema(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectThema(bno);
	}

	@Override
	public void updateCategory(String period, String thema, int bno) {
		// TODO Auto-generated method stub
		try {
			dao.updateCategory(period,thema,bno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Historic_site_detailVO> allDetail() throws Exception {
		// TODO Auto-generated method stub
		return dao.allDetail();
	}

	@Override
	public void updatePeriod(int bno, String period) throws Exception {
		// TODO Auto-generated method stub
		dao.updatePeriod(bno,period);
	}

	@Override
	public void updateThema(Historic_siteVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateThema(vo);
	}

	
	//댓글 
	@Override
	public List<ReplyVO> historic_replylist() throws Exception {
		// TODO Auto-generated method stub
		return dao.historic_replylist();
	}

	
	
	@Override
	public void deleteReply(int rno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteReply(rno);
	}

	@Override
	public List<EditorReplyVO> editor_replylist() throws Exception {
		// TODO Auto-generated method stub
		return dao.editor_replylist();
	}

	@Override
	public void deleteEditReply(int rno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteEditReply(rno);
	}
	
	

}
