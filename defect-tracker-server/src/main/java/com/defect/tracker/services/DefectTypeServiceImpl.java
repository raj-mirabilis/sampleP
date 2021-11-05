package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.DefectType;
import com.defect.tracker.data.repositories.DefectTypeRepository;

@Service
public class DefectTypeServiceImpl implements DefectTypeService {
	@Autowired
	DefectTypeRepository defectTypeRepository;

	@Override
	public List<DefectType> getAllDefectType() {
		return defectTypeRepository.findAll();
	}

}
