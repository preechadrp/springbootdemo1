package com.mycom.springbootdemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.springbootdemo1.dto.UserDto;
import com.mycom.springbootdemo1.exception.CustomException;
import com.mycom.springbootdemo1.service.HelloWorldService;

import jakarta.validation.Valid;

@RestController
public class HelloWorld {

	private final HelloWorldService helloWorldService;

	public HelloWorld(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@GetMapping("/hello1")
	public String hello1() {
		//return "Hello World!";
		return this.helloWorldService.hello();
	}

	@PostMapping("/hello2")
	public String hello2() {
		return "Hello World2!";
	}

	@GetMapping("/user")
	public UserDto getUser() {
		return new UserDto("นายใจดี", "Joe@email.com", "1234");
	}

	@PostMapping("/user")
	public UserDto postUser(@RequestBody @Valid UserDto userDto) {
		return userDto;
	}

	@GetMapping("/custom-exception")
	public String testCustomException() {
		String name = "Joe";
		if (!"abc".equals(name)) {
			//throw new CustomException("abc is not allowed");
			//throw new CustomException("abc is not allowed", true);
			throw new CustomException(404, "abc is not allowed");
		}
		return "custom-exception";
	}
}
