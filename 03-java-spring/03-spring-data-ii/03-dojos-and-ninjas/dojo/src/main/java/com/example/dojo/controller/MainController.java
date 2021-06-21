package com.example.dojo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojo.model.Dojo;
import com.example.dojo.model.Ninja;
import com.example.dojo.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mSerivce;
	
	
	@GetMapping("/dojos/new")
	private String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo-new.jsp";
	}
	
	@PostMapping("/dojos/new")
	private String create(Dojo dojo) {
		this.mSerivce.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	

	@GetMapping("/dojos/{id}")
	public String singleDojo(@PathVariable("id") Long id, Model viewModel) {
		Dojo dojo = this.mSerivce.findDojo(id);
		viewModel.addAttribute("dojo",dojo);
		return "dojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	private String newNinja(@ModelAttribute("ninja") Ninja ninja,Model viewModel) {
		List<Dojo> allDojo = this.mSerivce.allDojos();
		viewModel.addAttribute("allDojo",allDojo);
		return "new-ninja.jsp";
	}
	
	
	@PostMapping("/ninjas/new")
	private String createNinja(Ninja ninja) {
		this.mSerivce.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
