package com.ssafy.selfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.selfit.model.dao.RoutineVideoDao;
import com.ssafy.selfit.model.dto.RoutineVideo;

@Service
public class RoutineVideoServiceImpl implements RoutineVideoService{

	@Autowired
	RoutineVideoDao routineDao;

	@Override
	public int insertRoutineVideo(RoutineVideo routineVideo) {
		return routineDao.insertRoutineVideo(routineVideo);
	}

	@Override
	public List<RoutineVideo> selectRoutineByDay(String userId, String day) {
		return routineDao.selectRoutineByDay(userId, day);
	}

	@Override
	public List<RoutineVideo> selectAllRoutines(String userId) {
		return routineDao.selectAllRoutines(userId);
	}

	@Override
	public int updateRoutineVideo(RoutineVideo routineVideo) {
		return routineDao.updateRoutineVideo(routineVideo);
	}

	@Override
	public int deleteRoutineVideo(String userId, String videoId, String day) {
		return routineDao.deleteRoutineVideo(userId, videoId, day);
	}
}
