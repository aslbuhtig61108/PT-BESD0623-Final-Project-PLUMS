package com.promineotech.plums.service;

import java.util.List;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;
import com.promineotech.plums.entity.NewBookRequest;

public interface BookService {

	/**
	 * 
	 * @param isbn
	 * @param genre
	 * @return
	 */
	Book createNewBook(NewBookRequest newBookEntry);
	
	List<Book> retrieveABook(String isbn, Genre genre);

	List<Book> retrieveAllBooks();
	
}
