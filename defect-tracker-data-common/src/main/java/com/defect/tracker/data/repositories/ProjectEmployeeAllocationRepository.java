package com.defect.tracker.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.ProjectEmp;

@Repository
public interface ProjectEmployeeAllocationRepository extends JpaRepository<ProjectEmp, Long> {

	boolean existsByModuleId(Long moduleId);

	List<ProjectEmp> findEmployeeByModuleId(Long moduleId);

	public List<ProjectEmp> findByModuleId(Long id);
}
