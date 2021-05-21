package com.arman.routing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(@RequestParam(value="name",defaultValue="Human",required=false) String name, Model viewModel) {
			viewModel.addAttribute("name",name);
	
		return "home.jsp";
	}
}
