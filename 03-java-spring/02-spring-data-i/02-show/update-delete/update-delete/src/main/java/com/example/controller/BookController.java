package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Book;
import com.example.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books")
	public String home(Model viewModel) {
		List<Book> allBooks = bookService.getAllBooks();
		viewModel.addAttribute("allBooks",allBooks);
		return "index.jsp";
	}
	
	@PostMapping("/books/add")
	//@Valid annotation checks to see if the submitted object passes validation
	public String addBook(@ModelAttribute("Book") Book book, BindingResult result) {

		if(result.hasErrors()) {
			return "add.jsp";  //going to WEB-INF file
		}
		this.bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/add")
	public String addBook(@ModelAttribute("Book") Book book) {
		return "add.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String findById(@PathVariable("id") Long id, Model viewModel) {
		Book getSingleBook = bookService.getSingleBook(id);
		viewModel.addAttribute("book",getSingleBook);
		return "showBook.jsp";
	}
	
	   @RequestMapping("/books/edit/{id}")
	    public String editBook(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBookByIndex(id);
	        if (book != null){
	            model.addAttribute("book", book);
	            return "EditBook.jsp";
	        }else{
	            return "redirect:/books";
	       }
	   }
	   
	   @PostMapping("/books/edit/{id}")
	    public String updateBook(@PathVariable("id") int id,  @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "editBook.jsp";
	        }else{
	            bookService.updateBook(book);
	            return "redirect:/books";
	        }
	    }
	   
	   @PostMapping(value="/books/delete/{id}")
	    public String destroyBook(@PathVariable("id") Long id) {
	        this.bookService.deleteBook(id);
	        return "redirect:/books";
	    }
}
