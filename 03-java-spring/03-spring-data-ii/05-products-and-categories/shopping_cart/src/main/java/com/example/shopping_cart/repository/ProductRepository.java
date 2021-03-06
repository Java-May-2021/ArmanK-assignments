package com.example.shopping_cart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping_cart.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
}
