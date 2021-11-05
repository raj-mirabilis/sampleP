package com.defect.tracker.data.dto;

public class DesignationDto {
	private long id;
	private String DesignationName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesignationName() {
		return DesignationName;
	}

	public void setDesignationName(String designationName) {
		DesignationName = designationName;
	}
}
