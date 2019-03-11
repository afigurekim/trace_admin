package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_detailVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.VisitorVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mappers.boardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+ ".read",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace +".update",vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete",bno);	
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<VisitorVO> allVisitor() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".allVisitor");
	}

	@Override
	public List<Historic_siteVO> topHistoric() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".topHistoric");
	}

	@Override
	public List<Historic_site_starVO> userStar() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".userStar");
	}

	@Override
	public List<Historic_siteVO> allHistoric() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".allHistoric");
	}

	@Override
	public String selectThema(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectThema",bno);
		
	}

	@Override
	public String selectPeriod(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectPeriod",bno);
	}

	@Override
	public void updateCategory(String period, String thema, int bno) throws Exception {
		// TODO Auto-generated method stub
		Map <String,Object> map = new HashMap<String,Object>();
		map.put("period", period);
		map.put("thema", thema);
		map.put("bno", bno);
		session.update(namespace+".updateCategory",map);
	}

	@Override
	public List<Historic_site_detailVO> allDetail() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".allDetail");
	}

	@Override
	public void updatePeriod(int bno, String period) throws Exception {
		// TODO Auto-generated method stub
		Map <String,Object> map = new HashMap<String,Object>();
		map.put("bno", bno);
		map.put("period", period);
		session.update(namespace+".updatePeriod",map);
	}

	@Override
	public void updateThema(int bno, String thema) throws Exception {
		// TODO Auto-generated method stub
		Map <String,Object> map = new HashMap<String,Object>();
		map.put("bno", bno);
		map.put("thema", thema);
		session.update(namespace+".updateThema",map);
	}
}
