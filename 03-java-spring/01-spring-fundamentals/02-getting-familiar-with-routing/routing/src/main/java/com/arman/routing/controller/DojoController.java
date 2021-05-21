package com.arman.routing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@GetMapping("/dojo")
	public String dojo() {
		return "The dojo is awesome!";
	}

	
	@GetMapping("/dojo/{dojo}")
	public String dojo(@PathVariable("dojo") String name) {
		switch(name) {
		case "burbank":
			return "Burbank Dojo is located in Southern Cali";	
		case "san-jose":
			return "SJ dojo is the headquarters";
		default:
			return "Dojo"+name;
				
		}
		
	}

	
}