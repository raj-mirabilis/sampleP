package com.defect.tracker.data.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "defect")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String defectDescription;
	private String str;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moduleId", nullable = false)
	private Module module;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submoduleId", nullable = false)
	private SubModule submodule;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignedBy", nullable = false)
	private Employee employee;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignedTo", nullable = false)
	private Employee employee2;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priorityId", nullable = false)
	private Priority priority;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "severityId", nullable = false)
	private Severity severity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "defectStatusId", nullable = false)
	private DefectStatus defectStatus;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "defectTypeId", nullable = false)
	private DefectType defectType;
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public SubModule getSubmodule() {
		return submodule;
	}

	public void setSubmodule(SubModule submodule) {
		this.submodule = submodule;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee2() {
		return employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public DefectStatus getDefectStatus() {
		return defectStatus;
	}

	public void setDefectStatus(DefectStatus defectStatus) {
		this.defectStatus = defectStatus;
	}

	public DefectType getDefectType() {
		return defectType;
	}

	public void setDefectType(DefectType defectType) {
		this.defectType = defectType;
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

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

}
