package com.lb.service;

import java.awt.Color;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;
import com.lb.search.SearchRequest;
import com.lb.util.ExcelGenerator;
import com.lb.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

	private final CitizenRepo citizenRepo;
	
	private final ExcelGenerator excelGenerator;
	
	private final PdfGenerator pdfGenerator;

	@Override
	public List<String> getPlanStatus() {
		return citizenRepo.getCitizenStatus();
	}

	@Override
	public List<String> getPlanName() {
		return citizenRepo.getCitizenName();
	}

	@Override
	public List<CitizenReports> Search(SearchRequest request) {
		CitizenReports entity = new CitizenReports();
//		BeanUtils.copyProperties(search, report);
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getCitizenStatus() && !"".equals(request.getCitizenStatus())) {
			entity.setCitizenStatus(request.getCitizenStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {

			entity.setStartDate(request.getStartDate());
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {

			entity.setEndDate(request.getEndDate());
		}
		return citizenRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenReports> list = citizenRepo.findAll();
		excelGenerator.excelGenerator(response, list);
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<CitizenReports> list = citizenRepo.findAll();
		pdfGenerator.pdfGenerator(response, list);
		return true;
	}

}
