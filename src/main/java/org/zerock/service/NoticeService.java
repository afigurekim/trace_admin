package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.NoticeCriteria;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.SearchCriteria;

@Service
public interface NoticeService {

	
	public List<NoticeVO> listAll() throws Exception;
	
	public void create(NoticeVO vo) throws Exception;

	public NoticeVO read(Integer bno) throws Exception;
	
	public void update(NoticeVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<NoticeVO> listCriteria(NoticeCriteria cri)throws Exception;
	
	public int listCount()throws Exception;
	
	public List<NoticeVO> listSearchCriteria(SearchCriteria cri)throws Exception;
	
	public int listSearchCount() throws Exception;


	
}
