package com.defect.tracker.services;

import java.util.List;
import com.defect.tracker.data.entities.SubModule;

public interface SubModuleService {

	public void createSubModule(SubModule subModule);

	public List<SubModule> findSubModule(Long id);

	public List<SubModule> findAllSubModule();

	public void Update(SubModule submodule);

	public void deleteSubModuleById(Long id);

	public boolean existById(Long id);

	public boolean existsSubModule(Long id);

	public boolean existsByModuleId(Long id);

	public boolean existsBySubModuleName(String name);
}
