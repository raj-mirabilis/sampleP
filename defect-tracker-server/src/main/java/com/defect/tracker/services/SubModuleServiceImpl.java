package com.defect.tracker.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.entities.SubModule;
import com.defect.tracker.data.repositories.SubModuleRepository;

@Service
public class SubModuleServiceImpl implements SubModuleService {

	@Autowired
	private SubModuleRepository subModuleUpdateRepository;

	@Override
	public void createSubModule(SubModule subModule) {
		subModuleUpdateRepository.save(subModule);
	}

	@Override
	public List<SubModule> findSubModule(Long id) {
		return subModuleUpdateRepository.findByModuleId(id);
	}

	@Override
	public void Update(SubModule submodule) {
		subModuleUpdateRepository.save(submodule);
	}

	@Override
	public void deleteSubModuleById(Long id) {
		subModuleUpdateRepository.deleteById(id);
	}

	@Override
	public boolean existById(Long id) {
		return subModuleUpdateRepository.existsByModuleId(id);
	}

	@Override
	public boolean existsSubModule(Long id) {
		return subModuleUpdateRepository.existsById(id);
	}

	@Override
	public boolean existsByModuleId(Long id) {
		return subModuleUpdateRepository.existsByModuleId(id);
	}

	@Override
	public boolean existsBySubModuleName(String name) {
		return subModuleUpdateRepository.existsBysubmoduleName(name);
	}

	@Override
	public List<SubModule> findAllSubModule() {
		return subModuleUpdateRepository.findAll();
	}

}
