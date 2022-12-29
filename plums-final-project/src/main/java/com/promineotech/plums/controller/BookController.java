package com.promineotech.plums.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.BookEntryRequest;
import com.promineotech.plums.entity.Genre;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/books")
@OpenAPIDefinition(info = @Info(title = "Book Management Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public interface BookController {

	// formatter:off
	@Operation(
		summary = "Create an entry for a book",
		description = "Returns the created Book",
		responses = { 
		    @ApiResponse(
		        responseCode = "201",
		        description = "The created Book is returned",
		        content = @Content(
		        	mediaType = "application/json",
		        	schema = @Schema(implementation = Book.class))),
		          @ApiResponse(
		            responseCode = "400", 
		            description = "The request parameters are invalid", 
		            content = @Content(mediaType = "application/json" )),
		          @ApiResponse(
		            responseCode = "404", 
		            description = "A Book component was not found with the input criteria",
		            content = @Content(mediaType = "application/json" )),
		          @ApiResponse(
		            responseCode = "500", 
		            description = "An unplanned error occurred.", 
		            content = @Content(mediaType = "application/json" ))
		},
		      
		parameters = {
		    @Parameter(
		        name = "newBookEntry",
		        required = true, 
		        description = "The book entry as JSON")
	      })
		  
	@PostMapping ("/createBookEntry")
	@ResponseStatus(code = HttpStatus.CREATED)
	Book createBookEntry(@Valid @RequestBody BookEntryRequest newBookEntry);	
	// formatter:on
	
	// formatter:off
	@Operation(
		summary = "Returns all books",
		description = "Returns all Books found in the Books database of the PLUMS",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "All Books are listed",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Book.class))),
			@ApiResponse(
				responseCode = "500",
				description = "An unplanned error occurred.",
				content = @Content(mediaType = "application/json"))
		}	
	
	)

	@GetMapping ("/booksAllBooks")
	@ResponseStatus(code = HttpStatus.OK)
	List<Book> retrieveAllBooks();
	// formatter:on
	
	
	// formatter:off
	@Operation(
		summary = "Returns a list of books",
		description = "Returns a list of book(s) given an ISBN number or a genre",
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
				name = "isbn",
				allowEmptyValue = false,
				required = false,
				description = "The unique ISBN number usually found on the back cover of the book (i.e., '000-0-0000-0000-0')"),
			@Parameter(
				name = "genre",
				allowEmptyValue = false,
				required = false,
				description = "The genre the book is categorized (i.e., 'JAVA')")
		}
	)

	@GetMapping ("/booksByIsbnGenre")
	@ResponseStatus(code = HttpStatus.OK)
	List<Book> retrieveABook(
		@RequestParam(required = false)
			String isbn,
		@RequestParam(required = false)
			Genre genre);
	// formatter:on
	

}
