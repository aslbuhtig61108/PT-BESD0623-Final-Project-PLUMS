package com.promineotech.plums.dao;

import java.util.List;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

public interface BookDao {

		
	List<Book> retrieveABook(String isbn, Genre genre);

	List<Book> retrieveAllBooks();

	Book saveNewBook(String title, String isbn, String book_authors, String genre, String notes);

	


}
