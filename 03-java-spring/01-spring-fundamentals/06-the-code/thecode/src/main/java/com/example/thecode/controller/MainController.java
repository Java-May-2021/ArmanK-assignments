package com.example.thecode.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(@ModelAttribute("errors") String errors,Model viewModel) {
		viewModel.addAttribute("errors",errors);
		return "Home.jsp";
	}
	
	@PostMapping("/code")
	public String code(@RequestParam("code") String code ,RedirectAttributes redirectAttributes) {
		String confirmCode = "bushido";
		if(confirmCode.equals(code)) {
			return "Code.jsp";
		}
		redirectAttributes.addFlashAttribute("errors", "You must train harder");
		return "redirect:/";
	}
	
	@GetMapping("/code")
	public String redirectHome(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errors","Without Code you cannot access the page sorry!");
		return "redirect:/";
	}
}
