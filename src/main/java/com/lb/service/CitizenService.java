package com.lb.service;

import java.util.List;

import com.lb.entity.CitizenReports;
import com.lb.search.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenService {

	public List<String> getPlanStatus();

	public List<String> getPlanName();

	public List<CitizenReports> Search (SearchRequest search);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
