package com.defect.tracker.data.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.defect.tracker.data.entities.SubModule;

public interface SubModuleRepository extends JpaRepository<SubModule, Long> {
	public List<SubModule> findByModuleId(Long id);

	boolean existsByModuleId(Long id);

	public boolean existsBysubmoduleName(String name);

	public boolean existsBySubmoduleNameAndModuleId(String name, Long id);

}
