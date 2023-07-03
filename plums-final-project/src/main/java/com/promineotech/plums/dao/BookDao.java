package com.promineotech.plums.dao;

import java.util.List;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;
import com.promineotech.plums.entity.NewBookRequest;

public interface BookDao {

		
	List<Book> retrieveABook(String isbn, Genre genre);

	List<Book> retrieveAllBooks();

	Book saveNewBook(String title, String isbn, String book_authors, String genre, String notes);

	List<Book> updateSelectedBook(int booknumber_pk, NewBookRequest updateBookEntry);

	List<Book> removeABook(int booknumber_pk);

	


}
