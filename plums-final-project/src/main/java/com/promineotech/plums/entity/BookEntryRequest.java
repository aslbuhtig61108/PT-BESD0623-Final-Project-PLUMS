package com.promineotech.plums.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntryRequest {

	@NotNull
	@Length(max = 35)
	private String isbn;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private Genre genre;
	
	@NotNull
	@Length(max = 35)
	@Pattern(regexp = "[\\w\\s]*")
	private String title;
	
	@NotNull
	@Length(max = 35)
	@Pattern(regexp = "[\\w\\s]*")	
	private String authors;
	
	@NotNull
	@Length(max = 35)
	private String notes;
}
