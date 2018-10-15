package com.niit.Bean;

public class BorrowRecordBean {

	 private int id;
	 private String bookname;
	 private String author;
	 private double price;
	 private String releasingtime;
	 private String borrowdate;
	 private String shouldreturndate;
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
	public String getReleasingtime() {
		return releasingtime;
	}
	public void setReleasingtime(String releasingtime) {
		this.releasingtime = releasingtime;
	}
	 
	
	
	
}
