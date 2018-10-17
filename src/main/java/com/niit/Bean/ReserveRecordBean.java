package com.niit.Bean;

public class ReserveRecordBean {
 
	private int id;
	private int userid;
	private int bookid;
	private String username;
	private String bookname;
	private String author;
	private double price;
	private String releasingtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getReleasingtime() {
		return releasingtime;
	}
	public void setReleasingtime(String releasingtime) {
		this.releasingtime = releasingtime;
	}
	public ReserveRecordBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
	
	
	
	
}
