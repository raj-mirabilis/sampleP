package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.tracker.data.entities.DefectType;

public interface DefectTypeRepository extends JpaRepository<DefectType, Long> {

}
