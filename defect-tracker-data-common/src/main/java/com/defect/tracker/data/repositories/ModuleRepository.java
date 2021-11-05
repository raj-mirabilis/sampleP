package com.defect.tracker.data.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.defect.tracker.data.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	boolean existsByModuleName(String name);

	public List<Module> findByProjectId(Long projectId);

	boolean existsByProjectId(Long projectId);

	boolean existsByModuleNameAndProjectId(String moduleName, Long projectId);

}
