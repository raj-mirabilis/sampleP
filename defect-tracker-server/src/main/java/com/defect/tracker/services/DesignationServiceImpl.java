package com.defect.tracker.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Designation;
import com.defect.tracker.data.repositories.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	DesignationRepository designationRepository;

	@Override
	public List<Designation> getAlldesignation() {
		return designationRepository.findAll();
	}

}
