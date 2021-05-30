package com.example.ninjagold.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
	
	
	@GetMapping("/gold")
	public String index(HttpSession session,Model viewModel) {
		ArrayList<String> activities = new ArrayList<String>();
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activities);
		}
		viewModel.addAttribute("gold",session.getAttribute("gold"));
		viewModel.addAttribute("gold",session.getAttribute("activities"));
		return "home.jsp";
	}
	
	
	@PostMapping("/gold")
	public String gold(HttpSession session,@RequestParam(value="building") String building) {
		int goldThisTurn = 0;
		int gold = (int) session.getAttribute("gold");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");
		LocalDateTime now =  LocalDateTime.now();
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		Random r = new Random();
		if(building.equals("farm")) {
			goldThisTurn = r.nextInt(11)+10;
			session.setAttribute("gold", r.nextInt(11)+10);
			activities.add(String.format("You enter a %s and earned %s gold",building,goldThisTurn));
		}
		else if(building.equals("cave")) {
			session.setAttribute("gold", r.nextInt(6)+5);
			goldThisTurn =  r.nextInt(6)+5;
			activities.add(String.format("You enter a %s and earned %s gold",building,goldThisTurn));
		}
		else if(building.equals("house")) {
			goldThisTurn = r.nextInt(4)+2;
			session.setAttribute("gold", r.nextInt(4)+2);
			activities.add(String.format("You enter a %s and earned %s gold",building,goldThisTurn));
		}
		else if(building.equals("casino")) {
			goldThisTurn = r.nextInt(101)-50;
			if(goldThisTurn<0) {
				activities.add(String.format("You enter a %s and lost %s gold ouch",building,goldThisTurn));
			}
			else {
				activities.add(String.format("You enter a %s and earned %s gold",building,goldThisTurn));
			}
		
		}
		gold = gold+goldThisTurn;

		session.setAttribute("gold", gold);
		session.setAttribute("activity",activities);
		return "redirect:/gold";
	}
}
