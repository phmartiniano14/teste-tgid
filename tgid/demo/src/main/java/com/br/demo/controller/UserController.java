package com.br.demo.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.demo.model.UserModel;
import com.br.demo.service.UserService;

@RequestMapping("/User")
public class UserController {
	
	@Autowired   
	private UserService userService;
	
	@PostMapping
	   public  UserModel Conta(@RequestBody UserModel userModel ) {
		userService.tipoConta( userModel);
		return userModel;
		
		
		
	   }
	 
		
	}
	


