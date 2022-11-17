package com.promineotech.plums.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import com.promineotech.plums.controller.support.BookEntityCrudTestSupport;
import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = { "classpath:flyway/migrations/V1.0__Plums_Schema.sql",
		"classpath:flyway/migrations/V1.1__Plums_Data.sql" },
		config = @SqlConfig(encoding = "utf-8"))
class BookEntityCrudTest extends BookEntityCrudTestSupport {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void testDb() {
		int numberOfRows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "books");
		System.out.println("Number of Row =" + numberOfRows);
	}
	
	@Disabled
	@Test
	void testThatRetrievesEntireBookListByBookNumberOrGenre() {

		// Given: a request for the current book list either by book number or genre
		Genre genre = Genre.JAVA;
		String isbn = "978-0-13-767362-9";
		String uri = String.format("%s?genre=%s&isbn=%s", getBaseUri(), genre, isbn);

		// When: a connection is made to the URI
		ResponseEntity<List<Book>> result = getRestTemplate().exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<>() {
				});

		// Then: a success (OK - 200) status code is returned
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// And: the actual list returned is the same as the expected list
		List<Book> proposed = buildProposed();
		System.out.println(proposed);
		assertThat(result.getBody()).isEqualTo(proposed);
	}

}
