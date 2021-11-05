package com.defect.tracker.util;

/**
 * Contains all the rest endpoint url constants
 */
public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	private static final String ID = "/{id}";
	private static final String SLASH = "/";

	// Employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	public static final String EMPLOYEE_PHOTO = EMPLOYEE + SLASH + "photo" + ID;
	public static final String ACT_EMPLOYEE = EMPLOYEE + ID;
	public static final String GET_EMPLOYEE_BY_NAME = EMPLOYEE + SLASH + "firstname" + SLASH + "{firstName}";
	public static final String LOGINSTATUS = BASE_API_PATH + "login-status";
	public static final String GET_EMPLOYEE_BY_DESIGNATION = EMPLOYEE + SLASH + "designation" + SLASH
			+ "{designationId}";

	// Project
	public static final String PROJECT = BASE_API_PATH + "project";
	public static final String ACT_PROJECT = PROJECT + ID;

	// Module
	public static final String MODULE = BASE_API_PATH + "module";
	public static final String GET_MODULE_BY_PROJECT = MODULE + SLASH + "project" + SLASH + "{projectId}";
	public static final String MODULE_DELETE = MODULE + SLASH + "delete" + ID;

	// SubModule
	public static final String SUBMODULE = BASE_API_PATH + "submodule";
	public static final String GET_SUBMODULE = SUBMODULE + SLASH + "module" + SLASH + "{moduleId}";
	public static final String SUBMODULE_DELETE = SUBMODULE + SLASH + "delete" + ID;

	// Defect
	public static final String DEFECT = BASE_API_PATH + "defect";
	public static final String UPDATE_DEFECT_STATUS = DEFECT + ID + SLASH + "status" + SLASH + "{status}";
	public static final String DEFECT_GET_BY_ID = DEFECT + ID;
	public static final String GET_DEFECT_BY_ASSIGN_TO_ID = BASE_API_PATH + "get-all-defectlby-employee-id" + ID;
	public static final String GET_ALL_DEFECT_BY_PROJECT_ID = BASE_API_PATH + "get-all-defect-by-project-id" + ID;
	public static final String GET_DEFECT_BY_SERACH = BASE_API_PATH + "getDefectBySearch";

	// designation
	public static final String DESIGNATION = BASE_API_PATH + "designation";

	// projectEmployee
	public static final String EMPLOYEE_DEALLOCATION_FOR_SUBMODULE = BASE_API_PATH + "project-employee" + ID;

	// Project Deallocation
	public static final String PROJECT_ALLOCATION = BASE_API_PATH + "project-allocation";
	public static final String DEALLOCATE_PROJECT = PROJECT_ALLOCATION + ID;
	public static final String MODULE_ALLOCATION = BASE_API_PATH + "module-allocation";

	// projectEmp
	public static final String UPDATE_PROJECT_EMPLOYEE_ALLOCATION = PROJECT_ALLOCATION;
	public static final String GET_EMPLOYEE_BY_MODULE = PROJECT_ALLOCATION + "/get-emploee-by-module" + ID;

	// getAllStatus
	public static final String DEFECTSTATUS = BASE_API_PATH + "defect-status";
	public static final String DEFECT_STATUS = DEFECTSTATUS + SLASH + "defect" + ID;

	// DefectType
	public static final String DEFECTTYPE = BASE_API_PATH + "defect-type";

	// GetAllSeverity
	public static final String SEVERITY = BASE_API_PATH + "severity";

	// GetAllPriority
	public static final String PRIORITY = BASE_API_PATH + "priority";

	// Login
	public static final String LOGIN = BASE_API_PATH + "login";
	public static final String PASSWORD = BASE_API_PATH + "password";
	public static final String UPDATE_EMPLOYEE_STATUS = BASE_API_PATH + "employee-status-update" + SLASH + "email"
			+ SLASH + "{email}" + SLASH + "status" + SLASH + "{status}";
	public static final String FORGOT_PASSWORD = BASE_API_PATH + "forgot-password" + SLASH + "email" + SLASH
			+ "{email}";
	public static final String RESET_PASSWORD = BASE_API_PATH + "reset-password" + SLASH + "token" + SLASH + "{token}"
			+ SLASH + "password" + SLASH + "{password}";
	public static final String EMAIL_VERIFICATION = BASE_API_PATH + "email-verification" + SLASH + "email" + SLASH
			+ "{email}" + SLASH + "token" + SLASH + "{token}";

	private EndpointURI() {

	}
}
