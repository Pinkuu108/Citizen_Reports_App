package com.lb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lb.repo.CitizenRepo;

@Controller
public class CitizenController {

	@Autowired
	private CitizenRepo citizenRepo;
	
	@GetMapping("/")
	public String getHome()
	{
		return "home";
	}

}
