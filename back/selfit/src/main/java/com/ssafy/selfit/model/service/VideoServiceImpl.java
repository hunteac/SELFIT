package com.ssafy.selfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.selfit.model.dao.VideoDao;
import com.ssafy.selfit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoDao videoDao;
	
	@Override
	public int insertVideo(Video video) {
		return videoDao.insertVideo(video);
	}

	@Override
	public Video selectVideoById(String userId, String videoId) {
		return videoDao.selectVideoById(userId, videoId);
	}

	@Override
	public List<Video> selectAllVideos(String userId) {
		return videoDao.selectAllVideos(userId);
	}

	@Override
	public int deleteVideo(String userId, String videoId) {
		return videoDao.deleteVideo(userId, videoId);
	}

}
