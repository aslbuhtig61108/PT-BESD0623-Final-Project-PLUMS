package com.promineotech.plums.service;

import java.util.List;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

public interface BookService {

	/**
	 * 
	 * @param isbn
	 * @param genre
	 * @return
	 */
	List<Book> retrieveAllBooks(String isbn, Genre genre);

}
