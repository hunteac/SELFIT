package com.ssafy.selfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.selfit.model.dao.GrassDao;
import com.ssafy.selfit.model.dto.Grass;

@Service
public class GrassServiceImpl implements GrassService {

	@Autowired
	GrassDao grassDao;
	
	@Override
	public List<Grass> selectAllGrassesByMonth(String userId, String month) {
		return grassDao.selectAllGrassesByMonth(userId, month);
	}
	
	@Override
	public List<Grass> selectAllGrasses(String userId) {
		return grassDao.selectAllGrasses(userId);
	}

	@Override
	public int insertGrass(Grass grass) {
		return grassDao.insertGrass(grass);
	}
}
