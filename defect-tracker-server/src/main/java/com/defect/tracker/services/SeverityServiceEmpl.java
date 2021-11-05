package com.defect.tracker.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.entities.Severity;
import com.defect.tracker.data.repositories.SeverityRepository;

@Service
public class SeverityServiceEmpl implements SeverityService {

	@Autowired
	private SeverityRepository severityrepository;

	@Override
	public List<Severity> getAllSeverity() {
		return severityrepository.findAll();
	}

}
