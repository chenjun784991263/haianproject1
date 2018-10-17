package com.niit.model;

public class ReserveRecord {

	private int id;
	private int userid;
	private int bookid;
	private int flag=0;
	
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
	public ReserveRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReserveRecord(int userid , int bookid) {
		this.bookid=bookid;
		this.userid=userid;
		
		
		
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
	
	
	
}
