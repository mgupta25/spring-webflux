package com.example.springbootmongoreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongoreactive.service.UserDataService;
import com.example.springbootmongoreactive.vo.UserDataVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class UserDataController {
	
	@Autowired
	@Qualifier("com.example.springbootmongodb.service.UserDataServiceImpl")
	private UserDataService userDataService;
	
	@GetMapping("/getAllUsers")
	public Flux<UserDataVo> getAllUsers() {
		
		return userDataService.getAllUsers();
		
	}
	
	@PostMapping("/createUser")
	public Flux<UserDataVo> createUser(@RequestBody UserDataVo userDataVo) {
		return userDataService.createUser(userDataVo);
	}
	
	@GetMapping("/getUser")
	public Mono<ResponseEntity<UserDataVo>> getUser(@RequestParam("id") String id) {
		return userDataService.getUserById(id);
	}
	
}
