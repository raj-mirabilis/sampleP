package com.defect.tracker.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.entities.DefectStatus;
import com.defect.tracker.data.repositories.DefectStatusRepository;

@Service
public class DefectStatusServiceImpl implements DefectStatusService {

	@Autowired
	private DefectStatusRepository defectStatusRepository;

	@Override
	public List<DefectStatus> getAllDefectStatus() {
		return defectStatusRepository.findAll();
	}

	@Override
	public DefectStatus getDefectStatusByName(String name) {
		return defectStatusRepository.findByDefectStatusName(name);
	}

	@Override
	public Optional<DefectStatus> getDefectStatusById(Long id) {
		return defectStatusRepository.findById(id);
	}

}
