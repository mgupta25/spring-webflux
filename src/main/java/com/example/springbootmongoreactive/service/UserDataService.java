package com.example.springbootmongoreactive.service;

import org.springframework.http.ResponseEntity;

import com.example.springbootmongoreactive.vo.UserDataVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserDataService {
	
	Flux<UserDataVo> getAllUsers();
	Flux<UserDataVo> createUser(UserDataVo userDataVo);
	Mono<ResponseEntity<UserDataVo>> getUserById(String id);
}
