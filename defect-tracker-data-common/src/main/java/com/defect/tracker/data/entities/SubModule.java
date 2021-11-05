package com.defect.tracker.data.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submodule")
public class SubModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String submoduleName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moduleId", nullable = false)
	private Module module;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubmoduleName() {
		return submoduleName;
	}

	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
