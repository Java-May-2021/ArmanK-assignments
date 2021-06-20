package com.example.license.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.license.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
		
}
