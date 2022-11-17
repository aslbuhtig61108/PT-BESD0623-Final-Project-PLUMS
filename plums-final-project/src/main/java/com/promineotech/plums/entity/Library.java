package com.promineotech.plums.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Library {

	private int libraryid_pk;
	private int booknumber_fk;
}
