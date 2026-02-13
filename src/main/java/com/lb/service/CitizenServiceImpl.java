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

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Reports");
		Row headrow = sheet.createRow(0);

		headrow.createCell(0).setCellValue("citizenId");
		headrow.createCell(1).setCellValue("citizenName");
		headrow.createCell(2).setCellValue("planName");
		headrow.createCell(3).setCellValue("gender");
		headrow.createCell(4).setCellValue("citizenStatus");
		headrow.createCell(5).setCellValue("startDate");
		headrow.createCell(6).setCellValue("endDate");
		headrow.createCell(7).setCellValue("benefitAmount");

		List<CitizenReports> list = citizenRepo.findAll();
		int index = 1;
		for (CitizenReports plan : list) {
			Row data = sheet.createRow(index);

			data.createCell(0).setCellValue(plan.getCitizenId());
			data.createCell(1).setCellValue(plan.getCitizenName());
			data.createCell(2).setCellValue(plan.getPlanName());
			data.createCell(3).setCellValue(plan.getGender());
			data.createCell(4).setCellValue(plan.getCitizenStatus());
			if (null != plan.getStartDate()) {
				data.createCell(5).setCellValue(plan.getStartDate() + "");
			} else {
				data.createCell(5).setCellValue("N/A");
			}
			if (null != plan.getEndDate()) {
				data.createCell(6).setCellValue(plan.getEndDate() + "");
			} else {
				data.createCell(6).setCellValue("N/A");
			}

			if (null != plan.getBenefitAmount()) {
				data.createCell(7).setCellValue(plan.getBenefitAmount());
			} else {
				data.createCell(7).setCellValue("N/A");
			}

			index++;

		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Citizen", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setWidths(new float[]{1f, 2f, 2f, 1f, 2f, 2f, 2f, 2f});
		table.setSpacingBefore(10);

		table.addCell("citizenId");
		table.addCell("citizenName");
		table.addCell("planName");
		table.addCell("gender");
		table.addCell("citizenStatus");
		table.addCell("startDate");
		table.addCell("endDate");
		table.addCell("benefitAmount");

		List<CitizenReports> list = citizenRepo.findAll();
		for (CitizenReports plan : list) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getGender());
			table.addCell(plan.getCitizenStatus());
			table.addCell(String.valueOf(plan.getStartDate()));
			table.addCell(String.valueOf(plan.getEndDate()));
			table.addCell(String.valueOf(plan.getBenefitAmount()));
		}

		document.add(table);

		document.close();
		return true;
	}

}
