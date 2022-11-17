package com.promineotech.plums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;
import com.promineotech.plums.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultBookController implements BookController {

	@Autowired
	private BookService bookService;
	
	@Override
	public List<Book> retrieveBooks(Genre genre, String isbn) {
		log.info("genre={}, ISBN={}", genre, isbn);
		return bookService.retrieveBooks(genre, isbn);
	}

}