package com.ssafy.selfit.model.dto;

import java.util.Date;

public class Grass {
	private String userId;
	private Date date;
	
	public Grass() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;	
	}

	@Override
	public String toString() {
		return "Calender [userId=" + userId + ", date=" + date + "]";
	}
}
