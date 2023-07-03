package com.promineotech.plums.entity;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Comparable <Book>{

	private int booknumber_pk;
	private String title;
	private String isbn;
	private String book_authors;
	private Genre genre;
	private String notes;

	//  Unlike the video Jeep Order Project, having the primary key appear in the response body
	//  is much easier than having to update by isbn (reason LINES 25 ~ 28 are commented out) 
	//	@JsonIgnore
	//	public int getBooknumber_pk() {
	//		return booknumber_pk;
	//	}

	@Override
	public int compareTo(Book that) {
		// @formatter:off
		return Comparator
			.comparing(Book::getBooknumber_pk)
			.thenComparing(Book::getTitle)
			.thenComparing(Book::getGenre)
			.compare(this, that);
		// @formatter:on
	}
}
