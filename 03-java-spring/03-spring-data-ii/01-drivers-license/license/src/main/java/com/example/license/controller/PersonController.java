package com.example.license.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.license.model.License;
import com.example.license.model.Person;
import com.example.license.service.LicenseService;
import com.example.license.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService pService;
	
	@Autowired
	private LicenseService lService;
	
	@GetMapping("/licenese/new")
	public String license(@ModelAttribute(name="license") License license,Model viewModel) {
		List<Person> person = pService.findAllPerson();
		viewModel.addAttribute("personList",person);
		return "license/license-new.jsp";
	}
	
	
	@GetMapping("/create")
	public String createPage(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	@PostMapping("/create")
	public String create(Person person) {
		pService.createPerson(person);
		return "redirect:/licenese/new";
	}
	
	@PostMapping("/licenese/new")
	public String create(License license) {
		lService.createLicense(license);
		return "redirect:/licenese/new";	
	}
}
