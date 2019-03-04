package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.NoticeCriteria;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.SearchCriteria;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Inject
	SqlSession sqlsession;
	
	
	private static final String namespace = "org.zerock.mappers.noticeMapper";


	@Override
	public List<NoticeVO> listAll() throws Exception {
		
		return sqlsession.selectList(namespace+".listAll");
	}


	@Override
	public void create(NoticeVO vo) throws Exception {

		sqlsession.insert(namespace+".create",vo);	
	}


	@Override
	public NoticeVO read(Integer bno) throws Exception {
		
		return sqlsession.selectOne(namespace+".read",bno);
	}


	@Override
	public void update(NoticeVO vo) throws Exception {
		sqlsession.update(namespace+".update",vo);
	}


	@Override
	public void delete(Integer bno) throws Exception {
		
		sqlsession.delete(namespace+".delete",bno);
		
	}


	@Override
	public List<NoticeVO> listPage(int page) throws Exception {
		
		if(page<=0) {
			page=1;
		}
		page=(page-1)*10;
		
		return sqlsession.selectOne(namespace+".listPage",page);
	}


	@Override
	public List<NoticeVO> listCriteria(NoticeCriteria cri) throws Exception {
		
		return sqlsession.selectList(namespace+".listCriteria",cri);
	}


	@Override
	public int countPaging() throws Exception {
		
		return sqlsession.selectOne(namespace+".countPaging");
	}


	@Override
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception {
		
		return sqlsession.selectList(namespace+".listSearch",cri);
	}


	@Override
	public int listSearchCount() throws Exception {
	
		return sqlsession.selectOne(namespace+".listSearchCount");
	}


	@Override
	public void updateViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update(namespace+".updateViewCnt",bno);
	}

}
