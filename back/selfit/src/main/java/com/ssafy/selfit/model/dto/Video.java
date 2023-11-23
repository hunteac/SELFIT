package com.ssafy.selfit.model.dto;

public class Video {
	private String userId;
	private String videoId;
	
	public Video() {
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

	@Override
	public String toString() {
		return "Video [userId=" + userId + ", videoId=" + videoId + "]";
	}
}
