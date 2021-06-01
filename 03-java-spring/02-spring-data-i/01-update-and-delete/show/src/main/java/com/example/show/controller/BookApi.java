package com.example.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.show.model.Book;
import com.example.show.service.BookService;

@RestController
@RequestMapping("/api")
public class BookApi {
	@Autowired 
	BookService bservice;
	
	@GetMapping("/book/{id}")
	public Book getSingleBook(@PathVariable("id") Long id) {
		Book book = this.bservice.getSingleBook(id);
		return book;
	}
}
