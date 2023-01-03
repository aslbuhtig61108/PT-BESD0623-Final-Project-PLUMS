package com.promineotech.plums.controller;

import java.util.List;
import javax.validation.Valid;
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
//	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public Book createNewBook(@Valid NewBookRequest newBookEntry) {
		log.debug("Book={}", newBookEntry);

//		String bookBody = newBookEntry.toString();
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> bookEntity = new HttpEntity<>(bookBody, headers);
//		ResponseEntity<Book> response = restTemplate.exchange(null, HttpMethod.POST, bookEntity, Book.class);
				
		return bookService.createNewBook(newBookEntry);
	}

	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("Controller: ISBN={} or Genre={}", isbn, genre);
		return bookService.retrieveABook(isbn, genre);
	}
	
	@Override
	public List<Book> retrieveAllBooks() {
		// finalBookList value
		return bookService.retrieveAllBooks();
	}
	
}
