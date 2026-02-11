package com.lb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lb.repo.CitizenRepo;
import com.lb.search.SearchRequest;
import com.lb.service.CitizenService;

@Controller
public class CitizenController {

	private final CitizenRepo citizenRepo;

	@Autowired
	private CitizenService service;

	CitizenController(CitizenRepo citizenRepo) {
		this.citizenRepo = citizenRepo;
	}

	@PostMapping("/search")
	public String getSearch(SearchRequest request, Model model) {
		System.out.println(request);
		init(model);
		return "home";
	}

	@GetMapping("/")
	public String getHome(Model model) {

		
		init(model);

		return "home";
	}

	private void init(Model model) {
		model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}

}
