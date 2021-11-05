package com.defect.tracker.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubModuleDto {
	private Long id;

	@NotNull(message = "{subModuleDto.submoduleName.null}")
	@NotEmpty(message = "{subModuleDto.submoduleName.empty}")
	private String submoduleName;
	private Long moduleId;

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

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

}
