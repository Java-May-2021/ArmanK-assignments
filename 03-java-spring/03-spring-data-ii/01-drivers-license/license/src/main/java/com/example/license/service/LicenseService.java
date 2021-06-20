package com.example.license.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.license.model.License;
import com.example.license.repository.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;
	
	
	public void createLicense(License license) {
		lRepo.save(license);
	}
}
