package com.example.show.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.show.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findAll();
}
