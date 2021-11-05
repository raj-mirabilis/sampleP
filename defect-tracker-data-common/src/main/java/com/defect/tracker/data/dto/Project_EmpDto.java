package com.defect.tracker.data.dto;

public class Project_EmpDto {

	private long id;
	private long projectId;
	private long moduleId;
	private long employeeId;
	private long designationId;
	private long submoduleId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public long getSubmoduleId() {
		return submoduleId;
	}

	public void setSubmoduleId(long submoduleId) {
		this.submoduleId = submoduleId;
	}

}
