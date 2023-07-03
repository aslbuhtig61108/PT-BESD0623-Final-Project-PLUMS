package com.promineotech.plums.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;
import com.promineotech.plums.entity.NewBookRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBookDao implements BookDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// ===========================================================
	// Creates a new book entry

	@Override
	public Book saveNewBook(String title, String isbn, 
			String book_authors, String genre, String notes) {
		log.debug("DAO: New book with title={}, isbn={}, authors={},"
			+ " genre={}, and notes={}", title, isbn, book_authors, genre, notes);
			
		// @formatter:off
		String sql = ""
			+ "INSERT INTO books ("
			+ "title, isbn, book_authors, genre, notes"
			+ ") VALUES ("
			+ ":title, :isbn, book_authors, :genre, :notes)";
		// @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("title", title);
		params.put("isbn", isbn);
		params.put("book_authors", book_authors);
		params.put("genre", genre);
		params.put("notes", notes);
		
		jdbcTemplate.update(sql, params);
		
		//@formatter:off
		return Book.builder()
			.title(title)
			.isbn(isbn)
			.book_authors(book_authors)
			.genre(null)
			.notes(notes)
			.build();
		//@formatter:on
	}

	// ===========================================================

	// Retrieves a list of books from Books database
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("DAO: ISBN={} or Genre={}", isbn, genre);

		// @formatter:off
		String sql = ""
			+ " SELECT * "
			+ " FROM books "
			+ " WHERE isbn = :isbn OR genre = :genre"; 
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("isbn", isbn);
		params.put("genre", genre.toString());

		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Book.builder()
					.booknumber_pk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.isbn(rs.getString("isbn"))
					.book_authors(rs.getString("book_authors"))
					.genre(Genre.valueOf(rs.getString("genre")))
					.notes(rs.getString("notes"))
					.build();
				// @formatter:on
			}
		});
	}

	// This method retrieves a list of all available books in the Books table
	@Override
	public List<Book> retrieveAllBooks() {
		log.debug("DAO: All available books should be displayed");
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM books";
		// @formatter: on
		
		return jdbcTemplate.query(sql, new RowMapper<>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				// @formatter:off
				return Book.builder()
					.booknumber_pk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.isbn(rs.getString("isbn"))
					.book_authors(rs.getString("book_authors"))
					.genre(Genre.valueOf(rs.getString("genre")))
					.notes(rs.getString("notes"))
					.build();
					
				// @formatter:on
			}

		});
	}

	@Override
	public List<Book> updateSelectedBook(int booknumber_pk, NewBookRequest updateBookEntry) {
		// Continue from here L133 and deleting a book method (L139) after meeting with Steph
		return null;
	}

	@Override
	public List<Book> removeABook(int booknumber_pk) {
		// TODO Auto-generated method stub
		return null;
	}

}
