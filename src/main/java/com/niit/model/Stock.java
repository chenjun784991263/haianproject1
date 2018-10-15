package com.niit.model;

public class Stock {

  private int id;
  private int bookid;
  private int quantity;
  private String modifydate;

  
  public Stock() {
	super();
  }
public Stock(int bookid2, String quantity2, String date) {
	this.bookid=bookid2;
	this.quantity=Integer.parseInt(quantity2);
	this.modifydate=date;
	
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getModifydate() {
	return modifydate;
}
public void setModifydate(String modifydate) {
	this.modifydate = modifydate;
}
	
  
	
	
	
	
	
}
