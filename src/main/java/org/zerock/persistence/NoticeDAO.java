package org.zerock.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.NoticeCriteria;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.SearchCriteria;

@Repository
public interface NoticeDAO {

	public List<NoticeVO> listAll() throws Exception;
	
	public void create(NoticeVO vo) throws Exception;

	public NoticeVO read(Integer bno) throws Exception;
	
	public void update(NoticeVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<NoticeVO> listPage(int page)throws Exception;
	
	public List<NoticeVO> listCriteria(NoticeCriteria cri)throws Exception;

	public int countPaging()throws Exception;
	
	public List<NoticeVO> listSearch(SearchCriteria cri)throws Exception;
	
	public int listSearchCount()throws Exception;
	
	public void updateViewCnt(int bno)throws Exception;
	
}
