package com.nagarro.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyApi {

	@GetMapping
	public String getMe() {
		return "Hello from chetan mahajan, assingment-devops: I am in feature branch";
	}
	
}
