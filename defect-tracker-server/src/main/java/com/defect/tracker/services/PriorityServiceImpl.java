package com.defect.tracker.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Priority;
import com.defect.tracker.data.repositories.PriorityRepository;

@Service
public class PriorityServiceImpl implements PriorityService {

	@Autowired
	PriorityRepository priorityRepository;

	@Override
	public List<Priority> getAllPriority() {
		return priorityRepository.findAll();
	}

}
