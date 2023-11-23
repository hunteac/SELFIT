package com.ssafy.selfit.model.dto;

public class User {
	private String id;
	private String pwd;
	private String userName;
	
	public User() {
	}
	
	public User(String id, String pwd, String userName) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", userName=" + userName + "]";
	}
}
