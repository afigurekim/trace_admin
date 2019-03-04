package org.zerock.domain;

public class NoticeCriteria {
	
	private int page;	//page 수
	private int perPageNum;	//page당 게시물수

	public NoticeCriteria() {
		this.page=1;
		this.perPageNum=10;
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		
		this.perPageNum=perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	//method for Mybatis Sql Mapper-
	public int getPageStart() {
		return(this.page-1)*perPageNum;
	}
	

	//method for Mybatis Sql Mapper-
	public int getPerPageNum() {
		return this.perPageNum;
	}

	






	

	
	
	
}
