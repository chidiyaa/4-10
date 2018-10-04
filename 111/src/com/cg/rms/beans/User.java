package com.cg.rms.beans;

public class User {
	private String userName;
	private String password;
	private String typeUser;
	private String id;
	
	public User(String userName, String password, String typeUser) {
		super();
		this.userName = userName;
		this.password = password;
		this.typeUser = typeUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	
	public User(String userName, String password, String typeUser, String id) {
		super();
		this.userName = userName;
		this.password = password;
		this.typeUser = typeUser;
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", typeUser=" + typeUser + ", id=" + id + "]";
	}
	public User() {
		// TODO Auto-generated constructor stub
	}


}
