package com.niit.model;


public class Book {

	private int id;
	private String name;
	private String author;
	private String releasingtime;
	private double price;
	private String contenttype;
	private int publisherid;
	private int typeid;
	private int flag=1;//表示借出与否，默认未借出
	
	
	
	
	
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public int getPublisherid() {
		return publisherid;
	}
	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public Book() {
		super();
	
	}
	public Book(String bookname, String author2, String releasingtime2, String publisher, String price2,
			String contenttype2, String type) {
	  this.name=bookname;
	  this.author=author2;
	  this.releasingtime=releasingtime2;
	  this.publisherid=Integer.parseInt(publisher);
	  this.price=Double.parseDouble(price2);
	  this.contenttype=contenttype2;
	  this.typeid=Integer.parseInt(type);
	
	}
	public Book(String id2, String bookname, String author2, String releasingtime2, String publisher, String price2,
			String contenttype2, String type) {
		  this.id=Integer.parseInt(id2);
		  this.name=bookname;
		  this.author=author2;
		  this.releasingtime=releasingtime2;
		  this.publisherid=Integer.parseInt(publisher);
		  this.price=Double.parseDouble(price2);
		  this.contenttype=contenttype2;
		  this.typeid=Integer.parseInt(type);
		
	}
	
	
	
	
	
	
	
	
	
	
}
