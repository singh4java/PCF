package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.model.User;


@RestController
@RequestMapping("/user3")
public class UserController {
	
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@RequestMapping("/GET")
	private List<User> getUserData(){
		return userService.getUsers();
	}

	
}
