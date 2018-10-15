package com.niit.model;


public class Type {

	private int id;
	private String name;
	private String releasingtype;
	private String time;
	private int flag=1;
	
	
	
	
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(String typename, String releasingtype2, String time2) {

		this.name=typename;
		this.releasingtype=releasingtype2;
		this.time=time2;

		
		
		
		
		
		
	}
	public Type(String id2, String typename, String releasingtype2, String time2) {
		// TODO Auto-generated constructor stub
	   this.id=Integer.parseInt(id2);
		this.name=typename;
		this.releasingtype=releasingtype2;
		this.time=time2;

		
	
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
	public String getReleasingtype() {
		return releasingtype;
	}
	public void setReleasingtype(String relasingtype) {
		this.releasingtype = relasingtype;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
	
	
	
	
}
