package com.defect.tracker.data.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DefectDto {

	private long id;
	@NotEmpty(message = "{defectDto.defectDescription.Empty}")
	@NotNull(message = "{defectDto.defectDescription.Null}")
	@NotBlank(message = "{defectDto.defectDescription.Space}")
	private String defectDescription;
	@NotEmpty(message = "{defectDto.str.Empty}")
	@NotNull(message = "{defectDto.str.Null}")
	@NotBlank(message = "{defectDto.str.Space}")
	private String str;
	private long moduleId;
	private long submoduleId;
	private long employeeId;
	private long employee2Id;
	private long priorityId;
	private long severityId;
	private long defectStatusId;
	private long defectTypeId;
	private Date timeStamp;
	private String file;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDefectDescription() {
		return defectDescription;
	}

	public void setDefectDescription(String defectDescription) {
		this.defectDescription = defectDescription;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public long getSubmoduleId() {
		return submoduleId;
	}

	public void setSubmoduleId(long submoduleId) {
		this.submoduleId = submoduleId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getEmployee2Id() {
		return employee2Id;
	}

	public void setEmployee2Id(long employee2Id) {
		this.employee2Id = employee2Id;
	}

	public long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(long priorityId) {
		this.priorityId = priorityId;
	}

	public long getSeverityId() {
		return severityId;
	}

	public void setSeverityId(long severityId) {
		this.severityId = severityId;
	}

	public long getDefectStatusId() {
		return defectStatusId;
	}

	public void setDefectStatusId(long defectStatusId) {
		this.defectStatusId = defectStatusId;
	}

	public long getDefectTypeId() {
		return defectTypeId;
	}

	public void setDefectTypeId(long defectTypeId) {
		this.defectTypeId = defectTypeId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
