package com.niit.model;



public class User {
  private int id;
  private String name;
  private String gender;
  private String role;
  private String tel;
  private String loc;
  private String email;
  private String password;
  private int flag=1;
  
  
  
  public User(String name, String pass, String gender2, String tel2) {
    this.name=name;
	this.password=pass;
	this.gender=gender2;
	this.tel=tel2;
	  

}
public User(String name2, String pass) {
	this.name=name2;
	this.password=pass;
	
	
}
public User() {}

public User( String name2, String gender2, String role2, String tel2, String loc2,String email, String pass) {
	this.name=name2;
	this.gender=gender2;
	this.role=role2;
	this.tel=tel2;
	this.loc=loc2;
	this.email=email;
	this.password=pass;
	
	
	
}




public User(String id2, String username, String gender2, String role2, String tel2, String loc2, String email2,
		String password2) {
	this.id=Integer.parseInt(id2);
	this.name=username;
	this.gender=gender2;
	this.role=role2;
	this.tel=tel2;
	this.loc=loc2;
	this.email=email2;
	this.password=password2;
	
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
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
