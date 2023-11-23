package com.ssafy.selfit.model.dao;

import java.util.List;

import com.ssafy.selfit.model.dto.RoutineVideo;

public interface RoutineVideoDao {
	int insertRoutineVideo(RoutineVideo routineVideo);

	List<RoutineVideo> selectRoutineByDay(String userId, String day);
	
	List<RoutineVideo> selectAllRoutines(String userId);

	int updateRoutineVideo(RoutineVideo routineVideo);
	
	int deleteRoutineVideo(String userId, String videoId, String day);
}
