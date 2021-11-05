package com.defect.tracker.data.dto;

public class DefectProjectIdDto {
	Long moduleId;

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public DefectByEmployeeIdDto getDefectAssignDto() {
		return defectAssignDto;
	}

	public void setDefectAssignDto(DefectByEmployeeIdDto defectAssignDto) {
		this.defectAssignDto = defectAssignDto;
	}

	DefectByEmployeeIdDto defectAssignDto;

}
