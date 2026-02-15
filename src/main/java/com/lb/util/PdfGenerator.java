package com.lb.util;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	@Autowired
	private CitizenRepo citizenRepo;

	public void pdfGenerator(HttpServletResponse response, List<CitizenReports> plans,File f) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document,new FileOutputStream(f));
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Citizen", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1f, 2f, 2f, 1f, 2f, 2f, 2f, 2f });
		table.setSpacingBefore(10);

		table.addCell("citizenId");
		table.addCell("citizenName");
		table.addCell("planName");
		table.addCell("gender");
		table.addCell("citizenStatus");
		table.addCell("startDate");
		table.addCell("endDate");
		table.addCell("benefitAmount");

		// List<CitizenReports> list = citizenRepo.findAll();
		for (CitizenReports plan : plans) {
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
	}
}
