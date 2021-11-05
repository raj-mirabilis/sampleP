package com.defect.tracker.data.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.defect.tracker.data.entities.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long> {
	public List<Defect> findByDefectStatusId(Long sid);

	public List<Defect> findByEmployee2IdAndDefectStatusId(Long id, Long sid);

	public List<Defect> findByModuleIdAndDefectStatusId(Long id, Long sid);
}
