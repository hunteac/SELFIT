package com.ssafy.selfit.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.selfit.model.dto.Video;
import com.ssafy.selfit.model.service.VideoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/videoapi")
@CrossOrigin("*")
public class VideoRestController {
	
	@Autowired
	VideoService videoService;
	
	@PostMapping("/video")
	@ApiOperation(value = "하나의 비디오 정보를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insertVideo(@RequestBody Video video) {
		int result = videoService.insertVideo(video);
		
		if (result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/video/{userId}")
	@ApiOperation(value = "유저의 등록된 모든 비디오 정보를 반환한다.", response = Video.class)
	public ResponseEntity<?> selectAllVideos(@PathVariable String userId) {
		List<Video> list = videoService.selectAllVideos(userId);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/video/{userId}/{videoId}")
	@ApiOperation(value = "유저의 등록된 비디오 정보 중 videoid가 일치하는 비디오 정보를 반환한다.", response = Video.class)
	public ResponseEntity<?> selectVideoById(@PathVariable String userId, @PathVariable String videoId) {
		Video video = videoService.selectVideoById(userId, videoId);
		
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	@DeleteMapping("/video/{userId}/{videoId}")
	@ApiOperation(value = "유저 비디오 목록 중 videoid가 일치하는 비디오 정보를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> deleteVideo(@PathVariable String userId, @PathVariable String videoId) {
		int result = videoService.deleteVideo(userId, videoId);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
}
