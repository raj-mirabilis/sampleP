package com.defect.tracker.data.dto;

import java.util.List;

public class DefectByProjectIdDto {
	private int total;
	private List<DefectByEmployeeIdDto> defectAssignDto;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<DefectByEmployeeIdDto> getDefectAssignDto() {
		return defectAssignDto;
	}

	public void setDefectAssignDto(List<DefectByEmployeeIdDto> defectAssignDto) {
		this.defectAssignDto = defectAssignDto;
	}

}
