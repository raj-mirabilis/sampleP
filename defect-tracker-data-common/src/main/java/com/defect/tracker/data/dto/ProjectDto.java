package com.defect.tracker.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProjectDto {

	private Long id;
	@NotNull(message = "{projectDto.projectName.null}")
	@NotEmpty(message = "{projectDto.projectName.empty}")
	private String projectName;

	@NotNull(message = "{projectDto.abbrevation.null}")
	@NotEmpty(message = "{projectDto.abbrevation.empty}")
	private String abbrevation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

}
