package com.promineotech.plums.dao;

import java.util.List;
import javax.validation.Valid;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;
import com.promineotech.plums.entity.NewBookRequest;

public interface BookDao {

	/**
	 * 
	 * @param isbn
	 * @param genre
	 * @return
	 */
	
	Book saveNewBook(@Valid NewBookRequest newBookEntry);
	
	List<Book> retrieveABook(String isbn, Genre genre);

	List<Book> retrieveAllBooks();




}
