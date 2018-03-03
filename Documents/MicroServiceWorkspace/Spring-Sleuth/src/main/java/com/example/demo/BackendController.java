package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class BackendController {

	@RequestMapping("/API")
	User getUser(){
		return new User("SSN001", "Manvendra", "Singh", "MAC001");
	}
	
}
