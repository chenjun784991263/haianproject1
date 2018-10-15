package com.niit.model;

public class Account {

	private int id;
	private int userid;
	private double balance;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
		}
	public Account(String userid2, String balance2) {
		this.userid=Integer.parseInt(userid2);
		this.balance=Double.parseDouble(balance2);
		
		
	}
	
	
	
	
	
	
}
