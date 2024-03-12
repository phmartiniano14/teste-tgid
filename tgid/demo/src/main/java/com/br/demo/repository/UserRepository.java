package com.br.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.demo.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
}
