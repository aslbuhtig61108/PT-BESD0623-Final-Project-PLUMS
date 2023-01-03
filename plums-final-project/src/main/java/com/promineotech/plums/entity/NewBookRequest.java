package com.promineotech.plums.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class NewBookRequest {

	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private String title;
	
	@NotNull
	private String isbn;

	@NotNull
	@Pattern(regexp = "[\\w\\s]*")	
	private String authors;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private Genre genre;
	
	@NotNull
	private String notes;
}
