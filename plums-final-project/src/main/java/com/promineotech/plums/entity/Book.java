package com.promineotech.plums.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private int booknumber_pk;
	private String isbn;
	private Genre genre;
	private String title;
	private String book_authors;
	private String notes;
	
	@JsonIgnore
	public int getBooknumber_pk() {
		return booknumber_pk;
	}
	
	
}
