package com.lb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public List<CitizenReports> Search (SearchRequest search) {

		List<CitizenReports> reports = citizenRepo.findAll();

		return reports.stream()
				.filter(r -> search.getPlanName() == null
						|| r.getPlanName().equals(search.getPlanName()))
				.filter(r -> search.getGender() == null
						|| r.getGender().equals(search.getGender()))
				.filter(r -> search.getCitizenStatus() == null
						|| r.getCitizenStatus().equals(search.getCitizenStatus()))
				.filter(r -> {
					if (search.getStartDate() != null && search.getEndDate() != null) {
						return !r.getStartDate().isBefore(search.getStartDate())
								&& !r.getEndDate().isAfter(search.getEndDate());
					}
					return true;
				})
				.collect(Collectors.toList());
	}

	@Override
	public boolean exportExcel() {
		try {
			
			List<CitizenReports> reports=citizenRepo.findAll();
			
			Workbook book=new XSSFWorkbook();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	@Override
	public boolean exportPdf() {
		List<CitizenReports> all = citizenRepo.findAll();
		// PDF generation logic here
		return true;
	}
}
