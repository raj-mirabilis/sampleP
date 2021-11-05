package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * contains custom error messages
 *
 */

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// Defect
	@Value("${validation.defect.notExist}")
	private String defectNotExist;

	@Value("${validation.defect.notExist}")
	private String defectEmployeeNotExist;

	// priority
	@Value("${validation.priority.notExist}")
	private String priorityNotExist;

	// severity
	@Value("${validation.severity.notExist}")
	private String severityNotExist;

	// defect_type
	@Value("${validation.defectType.notExist}")
	private String defectTypeNotFound;

	// defect_status
	@Value("${validation.defect.statusNotExists}")
	private String defectStatusNotExist;

	// designation
	@Value("${validation.designation.notExist}")
	private String designationNotExist;

	// Allocation
	@Value("${validation.projectAllocation.notExist}")
	private String projectAllocationNotExist;

	@Value("${validation.projectAllocation.failed}")
	private String projectAllocationFailed;

	// Employee
	@Value("${validation.employee.notExist}")
	private String employeeNotExist;

	@Value("${validation.firstName.notExist}")
	private String employeeNotExists;

	@Value("${validation.employeeIdType.notExist}")
	private String employeeIdNotFound;

	@Value("${validation.employee.alreadyExist}")
	private String employeeAlreadyExist;

	@Value("${validation.employee.notFound}")
	private String employeeNotFound;

	// project
	@Value("${validation.project.notExist}")
	private String projectNotExist;

	@Value("${validation.project.AlreadyExists}")
	private String projectNameAlreadyExists;

	// module
	@Value("${validation.module.notExist}")
	private String moduleNotExist;

	@Value("${validation.module.alreadyExist}")
	private String moduleAlreadyExist;

	// submodule
	@Value("${validation.subModule.notExist}")
	private String subModuleNotExist;

	@Value("${validation.subModule.AlreadyExist}")
	private String subModuleAlreadyExist;

	// projectEmployee
	@Value("{validation.projectemp.isProjectempExists}")
	private String projectemployeeAlreadyExists;

	@Value("${validation.projectModule.alreadyExist}")
	private String projectModuleAlreadyExist;

	@Value("${validation.project.getProjectemployeeNotExists}")
	private String projectemployeeNotExists;

	// login
	@Value("${validation.email.alreadyExist}")
	private String emailAlreadyExist;

	@Value("${validation.email.NotExist}")
	private String emailNotExist;

	@Value("${validation.password.notMatcht}")
	private String passwordNotMatch;

	@Value("${validation.email.Invalid}")
	private String emailInvalid;

	@Value("${validation.token.Invalid}")
	private String tokenInvalid;

	@Value("${validation.token.Expired}")
	private String tokenExpired;

	public String getTokenExpired() {
		return tokenExpired;
	}

	public void setTokenExpired(String tokenExpired) {
		this.tokenExpired = tokenExpired;
	}

	public String getTokenInvalid() {
		return tokenInvalid;
	}

	public void setTokenInvalid(String tokenInvalid) {
		this.tokenInvalid = tokenInvalid;
	}

	public String getEmailInvalid() {
		return emailInvalid;
	}

	public void setEmailInvalid(String emailInvalid) {
		this.emailInvalid = emailInvalid;
	}

	public String getEmailNotExist() {
		return emailNotExist;
	}

	public void setEmailNotExist(String emailNotExist) {
		this.emailNotExist = emailNotExist;
	}

	public String getDefectNotExist() {
		return defectNotExist;
	}

	public void setDefectNotExist(String defectNotExist) {
		this.defectNotExist = defectNotExist;
	}

	public String getDefectEmployeeNotExist() {
		return defectEmployeeNotExist;
	}

	public void setDefectEmployeeNotExist(String defectEmployeeNotExist) {
		this.defectEmployeeNotExist = defectEmployeeNotExist;
	}

	public String getPriorityNotExist() {
		return priorityNotExist;
	}

	public void setPriorityNotExist(String priorityNotExist) {
		this.priorityNotExist = priorityNotExist;
	}

	public String getSeverityNotExist() {
		return severityNotExist;
	}

	public void setSeverityNotExist(String severityNotExist) {
		this.severityNotExist = severityNotExist;
	}

	public String getDefectTypeNotFound() {
		return defectTypeNotFound;
	}

	public void setDefectTypeNotFound(String defectTypeNotFound) {
		this.defectTypeNotFound = defectTypeNotFound;
	}

	public String getDefectStatusNotExist() {
		return defectStatusNotExist;
	}

	public void setDefectStatusNotExist(String defectStatusNotExist) {
		this.defectStatusNotExist = defectStatusNotExist;
	}

	public String getDesignationNotExist() {
		return designationNotExist;
	}

	public void setDesignationNotExist(String designationNotExist) {
		this.designationNotExist = designationNotExist;
	}

	public String getProjectAllocationNotExist() {
		return projectAllocationNotExist;
	}

	public void setProjectAllocationNotExist(String projectAllocationNotExist) {
		this.projectAllocationNotExist = projectAllocationNotExist;
	}

	public String getProjectAllocationFailed() {
		return projectAllocationFailed;
	}

	public void setProjectAllocationFailed(String projectAllocationFailed) {
		this.projectAllocationFailed = projectAllocationFailed;
	}

	public String getEmployeeNotExist() {
		return employeeNotExist;
	}

	public void setEmployeeNotExist(String employeeNotExist) {
		this.employeeNotExist = employeeNotExist;
	}

	public String getEmployeeNotExists() {
		return employeeNotExists;
	}

	public void setEmployeeNotExists(String employeeNotExists) {
		this.employeeNotExists = employeeNotExists;
	}

	public String getEmployeeIdNotFound() {
		return employeeIdNotFound;
	}

	public void setEmployeeIdNotFound(String employeeIdNotFound) {
		this.employeeIdNotFound = employeeIdNotFound;
	}

	public String getEmployeeAlreadyExist() {
		return employeeAlreadyExist;
	}

	public void setEmployeeAlreadyExist(String employeeAlreadyExist) {
		this.employeeAlreadyExist = employeeAlreadyExist;
	}

	public String getEmployeeNotFound() {
		return employeeNotFound;
	}

	public void setEmployeeNotFound(String employeeNotFound) {
		this.employeeNotFound = employeeNotFound;
	}

	public String getProjectNotExist() {
		return projectNotExist;
	}

	public void setProjectNotExist(String projectNotExist) {
		this.projectNotExist = projectNotExist;
	}

	public String getProjectNameAlreadyExists() {
		return projectNameAlreadyExists;
	}

	public void setProjectNameAlreadyExists(String projectNameAlreadyExists) {
		this.projectNameAlreadyExists = projectNameAlreadyExists;
	}

	public String getModuleNotExist() {
		return moduleNotExist;
	}

	public void setModuleNotExist(String moduleNotExist) {
		this.moduleNotExist = moduleNotExist;
	}

	public String getModuleAlreadyExist() {
		return moduleAlreadyExist;
	}

	public void setModuleAlreadyExist(String moduleAlreadyExist) {
		this.moduleAlreadyExist = moduleAlreadyExist;
	}

	public String getSubModuleNotExist() {
		return subModuleNotExist;
	}

	public void setSubModuleNotExist(String subModuleNotExist) {
		this.subModuleNotExist = subModuleNotExist;
	}

	public String getSubModuleAlreadyExist() {
		return subModuleAlreadyExist;
	}

	public void setSubModuleAlreadyExist(String subModuleAlreadyExist) {
		this.subModuleAlreadyExist = subModuleAlreadyExist;
	}

	public String getProjectemployeeAlreadyExists() {
		return projectemployeeAlreadyExists;
	}

	public void setProjectemployeeAlreadyExists(String projectemployeeAlreadyExists) {
		this.projectemployeeAlreadyExists = projectemployeeAlreadyExists;
	}

	public String getProjectModuleAlreadyExist() {
		return projectModuleAlreadyExist;
	}

	public void setProjectModuleAlreadyExist(String projectModuleAlreadyExist) {
		this.projectModuleAlreadyExist = projectModuleAlreadyExist;
	}

	public String getProjectemployeeNotExists() {
		return projectemployeeNotExists;
	}

	public void setProjectemployeeNotExists(String projectemployeeNotExists) {
		this.projectemployeeNotExists = projectemployeeNotExists;
	}

	public String getEmailAlreadyExist() {
		return emailAlreadyExist;
	}

	public void setEmailAlreadyExist(String emailAlreadyExist) {
		this.emailAlreadyExist = emailAlreadyExist;
	}

	public String getPasswordNotMatch() {
		return passwordNotMatch;
	}

	public void setPasswordNotMatch(String passwordNotMatch) {
		this.passwordNotMatch = passwordNotMatch;
	}

}
