package com.arman.string.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping(value="/random",method=RequestMethod.GET)
	public String random() {
		return "Spring boot is great! So easy to just repond with strings";
	}
}
