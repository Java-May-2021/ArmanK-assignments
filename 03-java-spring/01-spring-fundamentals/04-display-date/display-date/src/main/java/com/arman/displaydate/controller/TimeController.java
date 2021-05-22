package com.arman.displaydate.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeController {
		@GetMapping("/")
		public String index() {
			return "home.jsp";
		}
		
		@GetMapping("/date")
		public String date(Model viewModel) {
			Date date = new Date();
			viewModel.addAttribute("date",date);
			return "date.jsp";
		}
		

		@GetMapping("/time")
		public String time(Model viewModel	) {
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			
			
			viewModel.addAttribute("time",formatter.format(date.getTime()));
			
		
			return "time.jsp";
		}
}
