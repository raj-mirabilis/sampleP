package com.defect.tracker.data.dto;

public class SubModuleResponseDto {
	private Long id;
	private String submoduleName;
	private ModuleDto module;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubmoduleName() {
		return submoduleName;
	}

	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}

	public ModuleDto getModule() {
		return module;
	}

	public void setModule(ModuleDto module) {
		this.module = module;
	}

}
