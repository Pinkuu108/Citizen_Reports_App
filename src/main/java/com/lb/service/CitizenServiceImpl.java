package com.lb.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lb.entity.CitizenReports;
import com.lb.repo.CitizenRepo;
import com.lb.search.SearchRequest;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
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
