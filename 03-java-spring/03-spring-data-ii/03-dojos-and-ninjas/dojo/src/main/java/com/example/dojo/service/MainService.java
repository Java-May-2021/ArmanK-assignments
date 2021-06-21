package com.example.dojo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojo.model.Dojo;
import com.example.dojo.model.Ninja;
import com.example.dojo.repository.DojoRepository;
import com.example.dojo.repository.NinjaRepository;

@Service
public class MainService {
		@Autowired
		private NinjaRepository nRepo;
		@Autowired
		private DojoRepository dRepo;
		
		// Services of Ninjas //
		
		public void createNinja(Ninja ninja) {
			 this.nRepo.save(ninja);
		}
		
		
		
		//Services of Dojo //
		
		public void createDojo(Dojo dojo) {
			this.dRepo.save(dojo);
		}
		
		public List<Dojo> allDojos(){
			return this.dRepo.findAll();
		}
		
		public Dojo findDojo(Long id) {
			return this.dRepo.findById(id).orElse(null);
		}
}
