package com.example.springbootmongoreactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.springbootmongoreactive.vo.UserDataVo;

public interface UserDataRepository extends ReactiveMongoRepository<UserDataVo, String>{

}
