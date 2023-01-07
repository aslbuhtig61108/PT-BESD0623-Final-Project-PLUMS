package com.promineotech.plums.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;
import com.promineotech.plums.entity.NewBookRequest;
import com.promineotech.plums.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultBookController implements BookController {

	@Autowired
	private BookService bookService;

	// This method requests user input to create a new book entry and saves it to the database
	@Override
	public Book createNewBook(NewBookRequest newBookEntry) {
		log.debug("Controller: New book={}", newBookEntry);			
		return bookService.createNewBook(newBookEntry);
	}

	// This method requests a list of available books filtered either by isbn and genre parameters
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("Controller: ISBN={} or Genre={}", isbn, genre);
		return bookService.retrieveABook(isbn, genre);
	}
	
	// This method requests an entire list of available books in the current database
	@Override
	public List<Book> retrieveAllBooks() {
		return bookService.retrieveAllBooks();
	}
	
}
