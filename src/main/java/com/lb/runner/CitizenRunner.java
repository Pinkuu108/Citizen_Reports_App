package com.lb.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;

@Component
public class CitizenRunner implements ApplicationRunner {

	@Autowired
	private CitizenRepo citizenRepo;

	@Override
	public void run(ApplicationArguments args) {

		citizenRepo.deleteAll();
		
		// ---------------- CASH ----------------
		CitizenReports c1 = new CitizenReports();
		c1.setCitizenName("Pinku");
		c1.setPlanName("Cash");
		c1.setGender("Male");
		c1.setCitizenStatus("APPROVED");
		c1.setStartDate(LocalDate.now());
		c1.setEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(5000.00);

		CitizenReports c2 = new CitizenReports();
		c2.setCitizenName("Bapu");
		c2.setPlanName("Cash");
		c2.setGender("Male");
		c2.setCitizenStatus("DENIED");
		c2.setStartDate(LocalDate.now());
		c2.setDeniedReason("Rental Income");

		CitizenReports c3 = new CitizenReports();
		c3.setCitizenName("Chinu");
		c3.setPlanName("Cash");
		c3.setGender("Female");
		c3.setCitizenStatus("TERMINATED");
		c3.setStartDate(LocalDate.now().minusMonths(4));
		c3.setEndDate(LocalDate.now().plusMonths(6));
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminatedReason("Employed");
		c3.setBenefitAmount(5000.00);

		// ---------------- FOOD ----------------
		CitizenReports c4 = new CitizenReports();
		c4.setCitizenName("Santosh");
		c4.setPlanName("Food");
		c4.setGender("Male");
		c4.setCitizenStatus("APPROVED");
		c4.setStartDate(LocalDate.now());
		c4.setEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(4000.00);

		CitizenReports c5 = new CitizenReports();
		c5.setCitizenName("Happy");
		c5.setPlanName("Food");
		c5.setGender("Male");
		c5.setCitizenStatus("DENIED");
		c5.setStartDate(LocalDate.now());
		c5.setDeniedReason("Personal Issue");

		CitizenReports c6 = new CitizenReports();
		c6.setCitizenName("Lizun");
		c6.setPlanName("Food");
		c6.setGender("Female");
		c6.setCitizenStatus("TERMINATED");
		c6.setStartDate(LocalDate.now().minusMonths(4));
		c6.setEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminatedReason("Employed");
		c6.setBenefitAmount(3000.00);

		// ---------------- MEDICAL ----------------
		CitizenReports c7 = new CitizenReports();
		c7.setCitizenName("Harry");
		c7.setPlanName("Medical");
		c7.setGender("Male");
		c7.setCitizenStatus("APPROVED");
		c7.setStartDate(LocalDate.now());
		c7.setEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(6000.00);

		CitizenReports c8 = new CitizenReports();
		c8.setCitizenName("Tungu");
		c8.setPlanName("Medical");
		c8.setGender("Male");
		c8.setCitizenStatus("DENIED");
		c8.setStartDate(LocalDate.now());
		c8.setDeniedReason("Personal Reason");

		CitizenReports c9 = new CitizenReports();
		c9.setCitizenName("Bidyut");
		c9.setPlanName("Medical");
		c9.setGender("Female");
		c9.setCitizenStatus("TERMINATED");
		c9.setStartDate(LocalDate.now().minusMonths(4));
		c9.setEndDate(LocalDate.now().plusMonths(6));
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminatedReason("Employed");
		c9.setBenefitAmount(8000.00);

		// ---------------- EMPLOYMENT ----------------
		CitizenReports c10 = new CitizenReports();
		c10.setCitizenName("Ram");
		c10.setPlanName("Employment");
		c10.setGender("Male");
		c10.setCitizenStatus("APPROVED");
		c10.setStartDate(LocalDate.now());
		c10.setEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmount(6000.00);

		CitizenReports c11 = new CitizenReports();
		c11.setCitizenName("Pintu");
		c11.setPlanName("Employment");
		c11.setGender("Male");
		c11.setCitizenStatus("DENIED");
		c11.setStartDate(LocalDate.now());
		c11.setDeniedReason("Verification Failed");

		CitizenReports c12 = new CitizenReports();
		c12.setCitizenName("Lipsa");
		c12.setPlanName("Employment");
		c12.setGender("Female");
		c12.setCitizenStatus("TERMINATED");
		c12.setStartDate(LocalDate.now().minusMonths(4));
		c12.setEndDate(LocalDate.now().plusMonths(6));
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminatedReason("Doctor");
		c12.setBenefitAmount(9000.00);

		// ---------------- SAVE ALL ----------------
		List<CitizenReports> citizens = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);

		citizenRepo.saveAll(citizens);
	}
}
