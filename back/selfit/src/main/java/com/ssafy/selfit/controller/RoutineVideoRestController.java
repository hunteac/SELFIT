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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.selfit.model.dto.RoutineVideo;
import com.ssafy.selfit.model.service.RoutineVideoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/routinevideoapi")
@CrossOrigin("*")
public class RoutineVideoRestController {
	
	@Autowired
	RoutineVideoService routineService;
	
	@PostMapping("/routinevideo")
	@ApiOperation(value = "하나의 루틴 영상을 저장한다.", response = Integer.class)
	public ResponseEntity<?> insertRoutineVideo(@RequestBody RoutineVideo routineVideo) {
		int result = routineService.insertRoutineVideo(routineVideo);
			
		if (result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/routinevideo/{userId}")
	@ApiOperation(value = "userId에 맞는 유저의 모든 루틴 정보를 반환한다.", response = RoutineVideo.class)
	public ResponseEntity<?> selectAllRoutines(@PathVariable String userId) {
		List<RoutineVideo> list = routineService.selectAllRoutines(userId);
				
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<RoutineVideo>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/routinevideo/{userId}/{day}")
	@ApiOperation(value = "요일에 맞는 유저의 루틴 정보를 반환한다.", response = RoutineVideo.class)
	public ResponseEntity<?> selectRoutineByDay(@PathVariable String userId, @PathVariable String day) {
		List<RoutineVideo> list = routineService.selectRoutineByDay(userId, day);
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<RoutineVideo>>(list, HttpStatus.OK);
		}
	}
	
	@PutMapping("/routinevideo")
	@ApiOperation(value = "하나의 루틴 정보를 수정한다.", response = Integer.class)
	public ResponseEntity<?> updateRoutineVideo(@RequestBody RoutineVideo routineVideo) {
		int result = routineService.updateRoutineVideo(routineVideo);
		
		if (result == 1) {
			return new ResponseEntity<RoutineVideo>(routineVideo, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/routinevideo/{userId}/{videoId}/{day}")
	@ApiOperation(value = "하나의 루틴 정보를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> deleteRoutineVideo(@PathVariable String userId, @PathVariable String videoId, @PathVariable String day) {
		int result = routineService.deleteRoutineVideo(userId, videoId, day);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
