package com.promineotech.plums.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/plums")
@OpenAPIDefinition(info = @Info(title = "Retrieve Book List Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })
public interface BookController {
	
	// formatter:off
	@Operation(
		summary = "Returns a list of Books",
		description = "Returns a list of Book(s) given a genre and an ISBN number",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of Books is returned",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Book.class))),
			@ApiResponse(
				responseCode = "400",
				description = "The search paramters are invalid",
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404",
				description = "No Book(s) were found with the input criteria",
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500",
				description = "An unplanned error occurred.",
				content = @Content(mediaType = "application/json"))
		},	
		
		parameters = {
			@Parameter(
				name = "genre",
				allowEmptyValue = false,
				required = false,
				description = "The genre the book is categorized (i.e., 'JAVA')"),
			@Parameter(
				name = "isbn",
				allowEmptyValue = false,
				required = false,
				description = "The unique ISBN number usually found on the back cover of the book (i.e., '000-0-0000-0000-0')")
		}
	)
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Book> retrieveBooks(
			@RequestParam(required = false)
				Genre genre,
			@RequestParam(required = false)
				String isbn);
	// formatter:on
}