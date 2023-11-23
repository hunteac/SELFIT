package com.ssafy.selfit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.selfit.model.dto.Grass;
import com.ssafy.selfit.model.service.GrassService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/grassapi")
@CrossOrigin("*")
public class GrassRestController {

	@Autowired
	GrassService grassService;
	
	@PostMapping("/grass")
	@ApiOperation(value = "유저의 루틴 완료 체크를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insertGrass(@RequestBody Grass grass) {
		int result = grassService.insertGrass(grass);
		
		if (result == 1) {
			return new ResponseEntity<Grass>(grass, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/grass/{userId}/{month}")
	@ApiOperation(value = "유저의 월별 체크를 반환한다.", response = Grass.class)
	public ResponseEntity<?> selectAllGrassesByMonth(@PathVariable String userId, @PathVariable String month) {
		List<Grass> list = grassService.selectAllGrassesByMonth(userId, month);
				
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Grass>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/grass/{userId}")
	@ApiOperation(value = "유저의 모든 체크를 반환한다.", response = Grass.class)
	public ResponseEntity<?> selectAllGrasses(@PathVariable String userId) {
		List<Grass> list = grassService.selectAllGrasses(userId);
				
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Grass>>(list, HttpStatus.OK);
		}
	}
}
