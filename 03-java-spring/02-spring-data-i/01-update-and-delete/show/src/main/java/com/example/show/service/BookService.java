package com.example.show.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.show.model.Book;
import com.example.show.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public Book getSingleBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	public List<Book> getAllBooks() {
		return this.bookRepo.findAll();
	}
}
