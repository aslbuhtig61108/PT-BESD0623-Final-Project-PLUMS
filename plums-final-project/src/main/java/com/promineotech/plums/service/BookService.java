package com.promineotech.plums.service;

import java.util.List;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

public interface BookService {

	/**
	 * 
	 * @param genre
	 * @param isbn
	 * @return
	 */
	List<Book> retrieveBooks(Genre genre, String isbn);

}