package com.example.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@PostMapping("/result")
	public String result(@RequestParam(value="name") String name,@RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment,Model viewModel) {
		viewModel.addAttribute("name",name);
		viewModel.addAttribute("location",location);
		viewModel.addAttribute("language",language);
		viewModel.addAttribute("comment",comment);
		if(language.equals("java")) {
			return "java.jsp";
		}
		return "result.jsp";
	}
}
