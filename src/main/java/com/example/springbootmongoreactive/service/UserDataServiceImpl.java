package com.example.springbootmongoreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootmongoreactive.repository.UserDataRepository;
import com.example.springbootmongoreactive.vo.UserDataVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service("com.example.springbootmongodb.service.UserDataServiceImpl")
public class UserDataServiceImpl implements UserDataService{
	
	@Autowired
	UserDataRepository userDataRepo;
	
	@Override
	public Flux<UserDataVo> getAllUsers() {
		return userDataRepo.findAll();
	}

	@Override
	public Flux<UserDataVo> createUser(UserDataVo userDataVo) {
		userDataRepo.insert(userDataVo);
		return userDataRepo.findAll();
	}

	@Override
	public Mono<ResponseEntity<UserDataVo>> getUserById(String id) {
		return userDataRepo.findById(id).map(userId -> ResponseEntity.ok(userId)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
}
