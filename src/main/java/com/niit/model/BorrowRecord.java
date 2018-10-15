package com.niit.model;



public class BorrowRecord {

	private int id;
	private int userid;
	private int bookid;
	private String borrowdate;
	private String shouldreturndate;//default add 90 in borrowdate
	
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
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getShouldreturndate() {
		return shouldreturndate;
	}
	public void setShouldreturndate(String shouldreturndate) {
		this.shouldreturndate = shouldreturndate;
	}
	public BorrowRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowRecord(String userid2, String bookid2, String borrowdate2, String shouldreturndate2) {
 
		this.userid=Integer.parseInt(userid2);
		this.bookid=Integer.parseInt(bookid2);
		this.borrowdate=borrowdate2;
		this.shouldreturndate=shouldreturndate2;

	}
	
	
	
	
	
}
