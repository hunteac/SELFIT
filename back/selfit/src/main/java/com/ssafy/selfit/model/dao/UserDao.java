package com.ssafy.selfit.model.dao;

import java.util.List;

import com.ssafy.selfit.model.dto.User;

public interface UserDao {
	List<User> selectAllUsers();

	User selectUserById(String id);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(String id);
}