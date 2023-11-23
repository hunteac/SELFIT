package com.ssafy.selfit.model.service;

import java.util.List;

import com.ssafy.selfit.model.dto.User;

public interface UserService {
	List<User> selectAllUsers();

	User selectUserById(String id);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(String id);
}
