package com.defect.tracker.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "defectStatus")
public class DefectStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String defectStatusName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDefectStatusName() {
		return defectStatusName;
	}

	public void setDefectStatusName(String defectStatusName) {
		this.defectStatusName = defectStatusName;
	}

}
