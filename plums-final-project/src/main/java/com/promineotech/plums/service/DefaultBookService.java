package com.promineotech.plums.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookService implements BookService {

	@Override
	public List<Book> retrieveBooks(Genre genre, String isbn) {
		log.info("The retrieveBooks method was called with genre={} and isbn={}", genre, isbn);
		return null;
	}

}