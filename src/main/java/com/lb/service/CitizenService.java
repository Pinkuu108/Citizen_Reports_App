package com.lb.service;

import java.util.List;

import com.lb.entity.CitizenReports;
import com.lb.search.SearchRequest;

public interface CitizenService {

	public List<String> getPlanStatus();

	public List<String> getPlanName();

	public List<CitizenReports> Seach(SearchRequest search);

	public boolean exportExcel();

	public boolean exportPdf();

}
