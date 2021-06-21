package com.example.shopping_cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_cart.model.Category;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.CategoryRepository;
import com.example.shopping_cart.repository.ProductRepository;

@Service
public class MainService {
	
	@Autowired
	private ProductRepository pRepo;
	
	@Autowired
	private CategoryRepository cRepo;
	
	public void createProduct(Product product) {
		 this.pRepo.save(product);
	}
	
	public void createCategory(Category category) {
		this.cRepo.save(category);
	}
	
	public Product getSingleProduct(Long id) {
		
		return this.pRepo.findById(id).orElse(null);
	}
	
	
	public Category getSingleCategory(Long id) {
		
		return this.cRepo.findById(id).orElse(null);
	}
	
	public List<Category> allCategories(){
		return this.cRepo.findAll();
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> selectedCategories = product.getCategories();
		selectedCategories.add(category); 
		this.pRepo.save(product);
	}
}
