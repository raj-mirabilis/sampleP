package com.defect.tracker.data.dto;

public class ProjectEmp_ResponseDto {
	private long id;
	private ProjectDto project;
	private ModuleDto module;
	private EmployeeDto employee;
	private DesignationDto designation;
	private SubModuleDto submodule;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProjectDto getProject() {
		return project;
	}

	public void setProject(ProjectDto project) {
		this.project = project;
	}

	public ModuleDto getModule() {
		return module;
	}

	public void setModule(ModuleDto module) {
		this.module = module;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public DesignationDto getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationDto designation) {
		this.designation = designation;
	}

	public SubModuleDto getSubmodule() {
		return submodule;
	}

	public void setSubmodule(SubModuleDto submodule) {
		this.submodule = submodule;
	}

}
