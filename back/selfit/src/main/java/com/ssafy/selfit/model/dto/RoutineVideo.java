package com.ssafy.selfit.model.dto;

public class RoutineVideo {
	private String userId;
	private String videoId;
	private String memo;
	private String day;
	private int num;
	private int start;
	private int end;
	
	public RoutineVideo() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getStart() {
		return start;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "RoutineVideo [userId=" + userId + ", videoId=" + videoId + ", memo=" + memo + ", day=" + day + ", num="
				+ num + ", start=" + start + ", end=" + end + "]";
	}
}
