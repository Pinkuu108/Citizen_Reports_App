package com.lb.search;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {

	private String planName;

	private String gender;

	private String citizenStatus;

	private LocalDate startDate;

	private LocalDate endDate;

}
