package com.arman.beltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arman.beltreviewer.models.Event;
import com.arman.beltreviewer.models.User;
import com.arman.beltreviewer.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	public Event getById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	public List<Event> eventsFilterByState(String state){
		return this.eRepo.findByState(state);
	}
	
	public List<Event> allEventsNotState(String state){
		return this.eRepo.findByStateIsNot(state);
	}
	
	 public Event updateEvent(Event event) {
	    	return this.eRepo.save(event);
	    }
	
	 
	 public void deleteEvent(Long id) {
	    	this.eRepo.deleteById(id);
	    }
	//join event
	public void joinedEvent(User user, Event event) {
				List<User> joinedUsers = event.getParticipators();
				joinedUsers.add(user);
				this.eRepo.save(event);
	}
			
	public void unjoinedEvent(User user, Event event) {
				List<User> joinedUsers = event.getParticipators();
				joinedUsers.remove(user);
				this.eRepo.save(event);
	}
	
	
	

	
}
