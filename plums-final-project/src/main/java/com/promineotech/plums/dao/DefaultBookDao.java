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

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBookDao implements BookDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

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
					.genre(Genre.valueOf(rs.getString("genre")))
					.book_authors(rs.getString("book_authors"))
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
				return Book.builder().booknumber_pk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.isbn(rs.getString("isbn"))
					.genre(Genre.valueOf(rs.getString("genre")))
					.book_authors(rs.getString("book_authors"))
					.notes(rs.getString("notes"))
					.build();
					
				// @formatter:on
			}

		});

	}
}
