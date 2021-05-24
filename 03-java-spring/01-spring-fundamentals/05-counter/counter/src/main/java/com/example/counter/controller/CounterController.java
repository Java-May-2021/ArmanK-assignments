package com.example.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {
	@GetMapping("/")
	
	public String index(HttpSession session)
	{
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		
		Integer currentCount = (Integer) session.getAttribute("counter");
		currentCount++;
		session.setAttribute("counter", currentCount);
		return "index.jsp";
		
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession session,Model viewModel)
	{
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		viewModel.addAttribute("count",session.getAttribute("counter"));
		return "counter.jsp";
	}
	
	@GetMapping("/morecount")
	public String counter2(HttpSession session,Model viewModel)
	{
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		
		Integer currentCount = (Integer) session.getAttribute("counter");
		currentCount = currentCount+2;
		session.setAttribute("counter", currentCount);
		return "index.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("counter", 0);
		return "counter.jsp";
	}
}
