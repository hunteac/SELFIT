package com.ssafy.selfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.selfit.model.dto.User;
import com.ssafy.selfit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	@ApiOperation(value = "유저 회원가입", response = Integer.class)
	public ResponseEntity<?> insertUser(@RequestBody User user) {
		int result = userService.insertUser(user);
		
		if (result == 1) return new ResponseEntity<String>("success", HttpStatus.OK);
		else return new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@GetMapping("/user")
	@ApiOperation(value = "등록된 모든 유저 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAllUsers() {
		List<User> list = userService.selectAllUsers();
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "userId가 일치하는 유저 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectUserById(@PathVariable String id) {
		User user = userService.selectUserById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user/login")
	@ApiOperation(value = "로그인 유저 정보를 확인한다.", response = User.class)
	public ResponseEntity<?> loginById(@RequestBody User user) {
		User temp = userService.selectUserById(user.getId());
		
		if (temp != null && temp.getId().equals(user.getId()) && temp.getPwd().equals(user.getPwd())) {
			return new ResponseEntity<User>(temp, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}
	
	@PutMapping("/user/{id}")
	@ApiOperation(value = "하나의 유저 정보를 수정한다.", response = Integer.class)
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String id) {
		int result = userService.updateUser(user);
		
		if (result == 1) {
			if (user.getId() == id) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
		}
		return null;
	}
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "id가 일치하는 유저 정보를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		int result = userService.deleteUser(id);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
}
