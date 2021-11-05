package com.defect.tracker.data.dto;

public class ProjectEmp_Module_ResponseDto {

	private long id;
	private ModuleDto module;
	private EmployeeDto employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
