package com.lb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;
import com.lb.search.SearchRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

	private final CitizenRepo citizenRepo;

	@Override
	public List<String> getPlanStatus() {
		return citizenRepo.getCitizenStatus();
	}

	@Override
	public List<String> getPlanName() {
		return citizenRepo.getCitizenName();
	}

	@Override
	public List<CitizenReports> Search(SearchRequest search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
