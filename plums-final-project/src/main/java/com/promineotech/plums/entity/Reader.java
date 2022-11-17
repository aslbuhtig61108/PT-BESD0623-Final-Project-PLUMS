package com.promineotech.plums.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
	
	private int reader_pk;
	private String reader_id;
	private int booknumber_fk;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	
}
