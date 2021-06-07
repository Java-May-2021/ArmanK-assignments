package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public Book getSingleBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	public String deleteBook(Long id) {
		bookRepo.deleteById(id);
		return "The Book has been deleted";
	}
	
	
	
	public Book findBookByIndex(Long id) {
		return bookRepo.findBookByIndex(id);
	}
	
	
}
