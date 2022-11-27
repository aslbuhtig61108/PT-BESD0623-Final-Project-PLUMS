package com.promineotech.plums.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.plums.controller.support.BookEntityCrudTestSupport;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @ActiveProfiles("test")
@Sql(scripts = { "classpath:flyway/migrations/V1.0__Plums_Schema.sql",
		"classpath:flyway/migrations/V1.1__Plums_Data.sql" },
		config = @SqlConfig(encoding = "utf-8"))
class BookEntityCrudTest extends BookEntityCrudTestSupport {
	
	
	@Test
	void testCreateNewBookReturnsSuccess201() {
		// Given: a book entry as JSON
		String body = createBookEntryBody();
		String uriForBooks = getBaseUriForBooks();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
		
		// When: the book entry is sent
		ResponseEntity<Book> newBookEntry = getRestTemplate().exchange(uriForBooks,
			HttpMethod.POST, bodyEntity, Book.class);
			
		// Then: a 201 status is returned
		assertThat(newBookEntry.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		// And: the returned book is correctly created
		assertThat(newBookEntry.getBody()).isNotNull();
		
		Book newBook = newBookEntry.getBody();
		// Limiting assertions to the following entities
		assertThat(newBook.getIsbn()).isEqualTo("978-0-13-767362-9");
		assertThat(newBook.getTitle()).isEqualTo("CORE JAVA: Volume 1: Fundamentals");
		assertThat(newBook.getGenre()).isEqualTo("JAVA");
		
	}


	
	@Disabled
	@Test
	void testThatRetrievesEntireBookListByBookNumberAndGenre() {

		// Given: a request for the current book list either by book number or genre
		String isbn = "978-0-13-767362-9";
		Genre genre = Genre.JAVA;
		String urir = String.format("%s?isbn=%s&genre=%s", getBaseUriForBooks(), isbn, genre);

		// When: a connection is made to the URI
		ResponseEntity<List<Book>> result = getRestTemplate().exchange(urir, HttpMethod.GET, null,
				new ParameterizedTypeReference<>() {});

		// Then: a success (OK - 200) status code is returned
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// And: the actual list returned is the same as the expected list
		
		List<Book> proposed = buildProposed();
		System.out.println(proposed);
		System.out.println(result.getBody());
		assertThat(result.getBody()).isEqualTo(proposed);
	}

}
