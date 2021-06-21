package com.example.dojo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dojo.model.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
