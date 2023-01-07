package com.promineotech.plums.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.plums.dao.BookDao;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.NewBookRequest;
import com.promineotech.plums.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookService implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional
	@Override
	public Book createNewBook(NewBookRequest newBookEntry) {
		log.info("Service: New book={}", newBookEntry);
		
		String title = newBookEntry.getTitle();
		String isbn = newBookEntry.getIsbn();
		String book_authors = newBookEntry.getAuthors();
		String genre = newBookEntry.getGenre().toString();
		String notes = newBookEntry.getNotes();
		
		return bookDao.saveNewBook(title, isbn, book_authors, genre, notes);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.info("The retrieveABook method was called with an ISBN={} or Genre={}", isbn, genre);
		List<Book> books = bookDao.retrieveABook(isbn, genre);
		
		// Validates the returned books 
		// from the dao in case of an empty list
		if (books.isEmpty()) {
			String errorMessage = String.format("No books were found with "
					+ "the provided isbn=%s and/or genre=%s", isbn, genre);
			throw new NoSuchElementException(errorMessage);
		}
		
		Collections.sort(books);
		return books;
	}

	@Transactional (readOnly = true)
	@Override
	public List<Book> retrieveAllBooks() {
		log.info("The retrieveAllBooks method was called without any parameters");		
		return bookDao.retrieveAllBooks();
	}

}
