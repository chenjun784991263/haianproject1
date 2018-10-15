package com.niit.model;

public class AccountRecord {

	private int id;
	private int accountid;
	private int bookid;
	private int loserecordid;
	private int overduelength;
	private double overduefine;
	private double losefine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getLoserecordid() {
		return loserecordid;
	}
	public void setLoserecordid(int loserecordid) {
		this.loserecordid = loserecordid;
	}
	public int getOverduelength() {
		return overduelength;
	}
	public void setOverduelength(int overduelength) {
		this.overduelength = overduelength;
	}
	public double getOverduefine() {
		return overduefine;
	}
	public void setOverduefine(double overduefine) {
		this.overduefine = overduefine;
	}
	public double getLosefine() {
		return losefine;
	}
	public void setLosefine(double losefine) {
		this.losefine = losefine;
	}
	public AccountRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountRecord(int accountid, int bookid, int timelength, double d) {

		this.bookid=bookid;
		this.accountid=accountid;
		this.overduelength=timelength;
		this.overduefine=d;
		
		
		
	}
	public AccountRecord(int accountid1, int bookid1, double price,int loserecordid) {

		this.bookid=bookid1;
		this.accountid=accountid1;
		this.loserecordid=loserecordid;
		this.losefine=price;
		
		
	}
	

	
}
