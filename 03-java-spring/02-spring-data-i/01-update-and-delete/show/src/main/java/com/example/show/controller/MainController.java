package com.example.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.show.model.Book;
import com.example.show.service.BookService;

@Controller
public class MainController {
		
	
	@Autowired
	private BookService bService;
	
	@RequestMapping("/books")
	public String index(Model viewModel) {
		viewModel.addAttribute("books",bService.getAllBooks());
		return "index.jsp";
	}
	
	@RequestMapping("/books/{id}")
	public String findBookById(Model viewModel, @PathVariable("id") Long id) {
		Book book = bService.getSingleBook(id);
		viewModel.addAttribute("book",book);
		return "show.jsp";
	}
}
