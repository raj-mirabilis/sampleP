package com.defect.tracker.data.dto;

public class DefectByEmployeeIdDto {
	private String status;
	private Long count;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(long i) {
		this.count = i;
	}

}
