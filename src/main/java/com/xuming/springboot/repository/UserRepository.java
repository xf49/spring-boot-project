package com.xuming.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.xuming.springboot.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {

	

}
