package com.lb.search;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchRequest {

	private String planName;

	private String gender;

	private String citizenStatus;

	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate endDate;

}
