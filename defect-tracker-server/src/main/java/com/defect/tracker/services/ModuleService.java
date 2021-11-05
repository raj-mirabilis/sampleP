package com.defect.tracker.services;

import java.util.List;
import com.defect.tracker.data.entities.Module;

public interface ModuleService {

	public void deleteModule(Long id);

	public boolean isModuleExists(Long id);

	public void addModule(Module module);

	public boolean isModuleExistsByName(String name);

	public List<Module> findAll();

	public List<Module> findByProject(Long projectId);

	public boolean isModuleExistsByProjectId(Long projectId);

	public List<Long> getModIdByProId(Long id);

}