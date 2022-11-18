package com.promineotech.plums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.plums.dao.BookDao;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookService implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> retrieveAllBooks(String isbn, Genre genre) {
		log.info("The retrieveAllBooks method was called with ISBN={} and Genre={}", isbn, genre);
		return bookDao.retrieveAllBooks(isbn, genre);
	}

}
