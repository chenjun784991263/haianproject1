package com.niit.model;

public class Publisher {

	private int id;
	private String name;
	private String loc;
	private String tel;
	private int flag=1;
	
	
	
	
	
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publisher(String publihsername, String loc2, String tel2) {
		this.name=publihsername;
		this.loc=loc2;
		this.tel=tel2;
		
		
		
	}
	public Publisher(String id2, String publihsername, String loc2, String tel2) {
		// TODO Auto-generated constructor stub
	  
		this.id=Integer.parseInt(id2);
		this.name=publihsername;
		this.loc=loc2;
		this.tel=tel2;
		
		
		
	
	
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
	
	
	
	
	
	
}
