package com.ssafy.selfit.model.dao;

import java.util.List;

import com.ssafy.selfit.model.dto.Video;

public interface VideoDao {
	int insertVideo(Video video);

	Video selectVideoById(String userId, String videoId);
	
	List<Video> selectAllVideos(String userId);
	
	int deleteVideo(String userId, String videoId);
}
