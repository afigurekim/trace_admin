package org.zerock.domain;

import java.util.Date;

public class NoticeVO {
	
	private int bno;
	private String title;
	private String writer;
	private Date reg_date;
	private Date update_date;
	private int view_cnt;
	private String content;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	@Override
	public String toString() {
		return "NoticeVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", reg_date=" + reg_date
				+ ", update_date=" + update_date + ", view_cnt=" + view_cnt + ", content=" + content + "]";
	}
	
	

}
