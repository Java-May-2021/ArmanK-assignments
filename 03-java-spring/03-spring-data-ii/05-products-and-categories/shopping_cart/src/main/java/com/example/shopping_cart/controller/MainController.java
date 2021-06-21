package com.example.shopping_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shopping_cart.model.Category;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mService;

	@GetMapping("/products/new")
	public String productCreate(@ModelAttribute("product") Product product)
	{
		return "new-product.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		this.mService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@GetMapping("/categories/new")
	public String categoryCreate(@ModelAttribute("category") Category category)
	{
		return "new-category.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newProduct(@ModelAttribute("category") Category category) {
		this.mService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	@GetMapping("/products/{id}")
	public String productPage(@ModelAttribute("category") Category category, @PathVariable("id") Long id,Model viewModel) {
		viewModel.addAttribute("product",this.mService.getSingleProduct(id));
		viewModel.addAttribute("categories",this.mService.allCategories());
		return "product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCatToProduct(@PathVariable("id") Long id,@RequestParam("categories")Long categoryId) {
		Product product = mService.getSingleProduct(id);
		Category category = mService.getSingleCategory(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		
		mService.createProduct(product);
		

		return "redirect:/products/" + product.getId();
	}
}
