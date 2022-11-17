package com.promineotech.plums.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryBook {

	private int librarybookid_pk;
	private int libraryid_fk;
	
	
}
