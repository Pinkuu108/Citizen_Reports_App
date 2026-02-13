package com.lb.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	@Autowired
	private CitizenRepo citizenRepo;

	public void excelGenerator(HttpServletResponse response, List<CitizenReports> plans) throws Exception {
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

		// List<CitizenReports> list = citizenRepo.findAll();
		int index = 1;
		for (CitizenReports plan : plans) {
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
	}

}
