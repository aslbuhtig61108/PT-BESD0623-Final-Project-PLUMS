package com.promineotech.plums.entity;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class BookEntryRequest {

	@NotNull
	private String isbn;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private Genre genre;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private String title;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")	
	private String authors;
	
	@NotNull
	private String notes;
}
