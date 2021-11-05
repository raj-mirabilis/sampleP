package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Designation;

@Service
public interface DesignationService {
	public List<Designation> getAlldesignation();

}
