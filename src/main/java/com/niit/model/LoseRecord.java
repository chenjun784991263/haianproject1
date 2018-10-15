package com.niit.model;

public class LoseRecord {

	private int id;
	private int userid;
	private int bookid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public LoseRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoseRecord(int userid, int bookid) {
		this.bookid=bookid;
		this.userid=userid;
		
	}
	
	
	
	
	
	
	
	
	
}
