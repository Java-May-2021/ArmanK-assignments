package com.arman.routing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo";
	}
	@GetMapping("/coding/python")
	public String python() {
		return "Python/Django was awesome";
	}
	
	@GetMapping("/coding/java")
	public String java() {
		return "Java/Spring is better";
	}
	
	
	
	
}
