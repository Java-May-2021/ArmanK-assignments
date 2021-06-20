package com.example.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.license.model.Person;
import com.example.license.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	
	public void createPerson(Person person) {
		pRepo.save(person);
	}
	
	public List<Person> findAllPerson(){
		return pRepo.findAll();
	}
}
