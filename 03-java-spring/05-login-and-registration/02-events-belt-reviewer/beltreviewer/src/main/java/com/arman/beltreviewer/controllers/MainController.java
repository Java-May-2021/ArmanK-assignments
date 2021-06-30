package com.arman.beltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arman.beltreviewer.models.Event;
import com.arman.beltreviewer.models.User;
import com.arman.beltreviewer.services.EventService;
import com.arman.beltreviewer.services.UserService;
import com.arman.beltreviewer.validators.UserValidator;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidator uValidator;
	
	@Autowired
	private EventService eService;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register( @Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session){
		 this.uValidator.validate(user, result);
		  if(result.hasErrors()) {
			  return "index.jsp";
		  }
		  User newUser = this.uService.registerUser(user);
		  session.setAttribute("user_id", newUser.getId());
		  return "redirect:/events";
		}
	
	@PostMapping("/login")
	public String loginUser(String email,String password,RedirectAttributes redirectAttributes,HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttributes.addFlashAttribute("error","Invalid credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("logout","You have been logout");
		return "redirect:/";
	}


	@GetMapping("/events")
	public String event(@ModelAttribute("event") Event event,Model viewModel, HttpSession session) 
	{
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.findById(userId);
		if(userId == null) {
			return "redirect:/";
		}
		List<Event> userEvents = this.eService.eventsFilterByState(user.getState());
		List<Event> otherEvents = this.eService.allEventsNotState(user.getState());
		
		viewModel.addAttribute("event",event);
		viewModel.addAttribute("userEvents",userEvents);
		viewModel.addAttribute("otherEvents",otherEvents);
		viewModel.addAttribute("user",user);

		return "event.jsp";
	}
	
	@PostMapping("/events/create")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result,HttpSession session,Model viewModel) {
		User user = uService.findById((Long)session.getAttribute("user_id"));
		if(user == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			List<Event> userEvents = this.eService.eventsFilterByState(user.getState());
			List<Event> otherEvents = this.eService.allEventsNotState(user.getState());
			
			viewModel.addAttribute("event",event);
			viewModel.addAttribute("userEvents",userEvents);
			viewModel.addAttribute("otherEvents",otherEvents);
			viewModel.addAttribute("user",user);
			return "event.jsp";
		}
		event.setHost(user);
		this.eService.createEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/join/{id}")
	public String joinEvent(@PathVariable("id") Long id,HttpSession session) {
		Event event = this.eService.getById(id);
		User user = this.uService.findById((Long) session.getAttribute("user_id"));
		this.eService.joinedEvent(user, event);
		return "redirect:/events";
		
	}
	
	@GetMapping("/events/unjoin/{id}")
	public String unJoinEvent(@PathVariable("id") Long id,HttpSession session) {
		Event event = this.eService.getById(id);
		User user = this.uService.findById((Long) session.getAttribute("user_id"));
		this.eService.unjoinedEvent(user, event);
		return "redirect:/events";
		
	}

	
	@GetMapping("/events/edit/{id}")
	public String editEvent(@PathVariable("id")Long id,Model model,HttpSession session,RedirectAttributes redirs,@ModelAttribute("event") Event event) {
		Event eventToEdit = this.eService.getById(id);
		Long userId = (Long) session.getAttribute("user_id");
		Long host_id =   eventToEdit.getHost().getId();
		if(!host_id.equals(userId)) {
			redirs.addFlashAttribute("error","You are  not allowing to change anything");
			return "redirect:/events";
		}
		User user = this.uService.findById(userId);
		model.addAttribute("event",eventToEdit);	
		model.addAttribute("user",user);
		return "edit.jsp";
	}
	
	@PostMapping("/events/edit/{id}")
	public String editEvents(@Valid @ModelAttribute("event") Event updatedEvent, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession  session) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.findById(userId);
		Event thisEvent = this.eService.getById(id);
		if(result.hasErrors()) {
			model.addAttribute("event", this.eService.getById(id));
			return "edit.jsp";
		}
		
		model.addAttribute("user", user);

		updatedEvent.setHost(user);
		this.eService.updateEvent(updatedEvent);
		return "redirect:/events";
		
	}
	
	@GetMapping("/events/delete/{id}")
	public String Delete(@PathVariable("id") Long id,HttpSession session,RedirectAttributes redirs) {
		Event eventToEdit = this.eService.getById(id);
		Long userId = (Long) session.getAttribute("user_id");
		Long host_id =   eventToEdit.getHost().getId();
		if(!host_id.equals(userId)) {
			redirs.addFlashAttribute("error","You are  not allowing to change anything");
			return "redirect:/events";
		}
		this.eService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}")
	public String singleEvent(@PathVariable("id") Long id, Model viewModel,HttpSession session) {
		User user = this.uService.findById((Long)session.getAttribute("user_id"));
		if(user == null) {
			return "redirect:/";
		}
		Event event = this.eService.getById(id);
		viewModel.addAttribute("event",event);
		return "singleEvent.jsp";
	}
}
