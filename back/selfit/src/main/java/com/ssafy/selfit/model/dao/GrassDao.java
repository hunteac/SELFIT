package com.ssafy.selfit.model.dao;

import java.util.List;

import com.ssafy.selfit.model.dto.Grass;

public interface GrassDao {
	List<Grass> selectAllGrassesByMonth(String userId, String month);
	
	List<Grass> selectAllGrasses(String userId);
	
	int insertGrass(Grass grass);
}
