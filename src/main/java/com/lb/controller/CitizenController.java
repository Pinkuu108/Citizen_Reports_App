package com.lb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;
import com.lb.search.SearchRequest;
import com.lb.service.CitizenService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenController {

	private final CitizenRepo citizenRepo;

	@Autowired
	private CitizenService service;

	CitizenController(CitizenRepo citizenRepo) {
		this.citizenRepo = citizenRepo;
	}

	@GetMapping("/excel")
	public void exportexcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	@GetMapping("/pdf")
	public void exportpdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}

	@PostMapping("/search")
	public String getSearch(@ModelAttribute("search") SearchRequest search, Model model) {
		System.out.println(search);
		List<CitizenReports> plan = service.Search(search);
		model.addAttribute("plans", plan);
		init(model);
		return "home";
	}

	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);

		return "home";
	}

	private void init(Model model) {

		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}

}
