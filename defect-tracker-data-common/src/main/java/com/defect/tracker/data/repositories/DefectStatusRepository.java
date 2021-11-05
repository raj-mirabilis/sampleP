package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.tracker.data.entities.DefectStatus;

public interface DefectStatusRepository extends JpaRepository<DefectStatus, Long> {

	public DefectStatus findByDefectStatusName(String name);

}
