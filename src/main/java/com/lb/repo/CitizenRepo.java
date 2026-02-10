package com.lb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lb.entity.CitizenReports;

public interface CitizenRepo extends JpaRepository<CitizenReports, Integer> {

	@Query("select distinct c.citizenName from CitizenReports c")
	List<String> getCitizenName();

	@Query("select distinct c.citizenStatus from CitizenReports c")
	List<String> getCitizenStatus();
}
