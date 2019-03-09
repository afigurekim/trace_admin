package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.NoticeCriteria;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	private NoticeDAO dao;

	@Override
	public List<NoticeVO> listAll() throws Exception {
		
		return dao.listAll();
	}

	@Override
	public void create(NoticeVO vo) throws Exception {

		dao.create(vo);
	}

@Transactional	
@Override
	public NoticeVO read(Integer bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		
		dao.update(vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		
		dao.delete(bno);
		
	}

	@Override
	public List<NoticeVO> listCriteria(NoticeCriteria cri) throws Exception {
		
		return dao.listCriteria(cri);
	}

	@Override
	public int listCount() throws Exception {
		
		return dao.countPaging();
	}

	@Override
	public List<NoticeVO> listSearchCriteria(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount() throws Exception {

		return dao.listSearchCount();
	}

}
