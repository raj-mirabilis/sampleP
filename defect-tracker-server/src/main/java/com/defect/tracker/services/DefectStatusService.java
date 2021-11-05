package com.defect.tracker.services;

import java.util.List;
import java.util.Optional;
import com.defect.tracker.data.entities.DefectStatus;

public interface DefectStatusService {
	public List<DefectStatus> getAllDefectStatus();

	public Optional<DefectStatus> getDefectStatusById(Long id);

	public DefectStatus getDefectStatusByName(String name);

}
