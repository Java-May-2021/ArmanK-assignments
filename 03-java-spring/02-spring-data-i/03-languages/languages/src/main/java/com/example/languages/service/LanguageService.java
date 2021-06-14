package com.example.languages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.languages.model.Language;
import com.example.languages.repository.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository lRepo;
		
		public List<Language> getAll(){
			return this.lRepo.findAll();
		}
	
		public Language getOne(Long id) {
			return this.lRepo.findById(id).orElse(null); 
		}
		
		
		public Language createNew(Language lang) {
			return this.lRepo.save(lang);
		}
		

		public Language update(Long id, Language lang) {
			Language updated = lRepo.findById(id).orElse(null);
			updated.setName(lang.getName());
			updated.setCreator(lang.getCreator());
			updated.setVersion(lang.getVersion());
			return this.lRepo.save(updated);
		}
		
		
		public void delete(Long id) {
			this.lRepo.deleteById(id);
		}
}
